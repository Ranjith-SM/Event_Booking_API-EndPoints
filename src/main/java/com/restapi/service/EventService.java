package com.restapi.service;

import com.restapi.dto.AddressDto;
import com.restapi.dto.EventDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.*;
import com.restapi.repository.*;
import com.restapi.request.AddressRequest;
import com.restapi.request.BookedEventsRequest;
import com.restapi.request.BookedUsersRequest;
import com.restapi.request.EventRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventDto eventDto;


    @Autowired
    private AddressDto addressDto;

    @Autowired
    private EventCategoryRepository categoryRepository;

    @Autowired
    private EventCategoryService categoryService;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private EventTicketRepository eventTicketRepository;

    @Autowired
    private BookedEventsRepository bookedEventsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookedUsedDetailsRepository bookedUsedDetailsRepository;

    @Autowired
    private StorageService storageService;


    public List<EventTicket> findAll() {
        return eventTicketRepository.findAll();
    }


    @Transactional
    public List<EventTicket> createEvent(EventRequest eventRequest) {
        System.out.println(eventRequest.getAddress());
        EventTicket event = eventDto.mapToEvent(eventRequest);
        AddressRequest addressRequest = addressDto.mapToAddressRequest(eventRequest);
        Address address = addressDto.mapToAddress(addressRequest);

        EventCategory category = categoryRepository.findById(eventRequest.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("CategoryId",
                        "CategoryId", eventRequest.getCategoryId()));
        System.out.println(category.getId());

        address = addressRepository.save(address);
        System.out.println(address.getId());

        event.setEventCategory(category);
        System.out.println(address.getId());
        event.setAddress(address);

        eventTicketRepository.save(event);
        return findAll();
    }

    @Transactional
    public List<EventTicket> updateEvent(EventRequest eventRequest) {
        EventTicket event = eventDto.mapToEvent(eventRequest);
        EventCategory category = categoryRepository.findById(eventRequest.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("CategoryId",
                        "CategoryId", eventRequest.getCategoryId()));

        AddressRequest addressRequest = addressDto.mapToAddressRequest(eventRequest);
        Address address = addressDto.mapToAddress(addressRequest);
        address = addressRepository.save(address);

        event.setEventCategory(category);
        event.setAddress(address);
        eventTicketRepository.save(event);
//        addressService.update(addressRequest);
        return findAll();
    }

    public List<EventTicket> deleteById(Integer id) {
        eventTicketRepository.deleteById(id);
        return findAll();
    }

    @Transactional
    public Object bookEvents(BookedEventsRequest bookedEventsRequest) {
        System.out.println(bookedEventsRequest.getUserId());
        AppUser appUser = userRepository.findById((long) bookedEventsRequest.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId", bookedEventsRequest.getUserId()));

        EventTicket event = eventTicketRepository.findById(bookedEventsRequest.getEventId())
                .orElseThrow(() -> new ResourceNotFoundException("eventId", "eventId", bookedEventsRequest.getEventId()));

        BookedEvents bookedEvents = new BookedEvents();
        bookedEvents.setEventTicket(event);
        bookedEvents.setAppUser(appUser);
        bookedEvents.setCount(bookedEventsRequest.getCount());
        bookedEvents = bookedEventsRepository.save(bookedEvents);


        List<BookedUserDetails> bookedUserDetails = new ArrayList<>();
        for (BookedUsersRequest userDetails : bookedEventsRequest.getUserDetails()) {
            BookedUserDetails  bookedUserDetails1 = new BookedUserDetails();
            EventTicket id = new EventTicket();

            id.setId(userDetails.getEventId());
            bookedEvents.setEventTicket(id);

            bookedUserDetails1.setEventid(bookedEvents);
            bookedUserDetails1.setName(userDetails.getName());
            bookedUserDetails1.setAge(userDetails.getAge());
            bookedUserDetails1.setGender(userDetails.getGender());
            BookedUserDetails userDetailsList= bookedUsedDetailsRepository.save(bookedUserDetails1);

            bookedUserDetails.add(userDetailsList);

        }

        bookedEvents.setUserDetails(bookedUserDetails);


        return bookedEvents;
    }

    public File getFile(Integer id) throws IOException {
        EventTicket eventTicket = eventTicketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id", "id", id));

        Resource resource = storageService.loadFileAsResource(eventTicket.getImage());
        return resource.getFile();
    }
}
