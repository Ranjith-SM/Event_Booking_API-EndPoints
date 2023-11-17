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
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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


    public List<EventTicket> findAll() {
        return eventTicketRepository.findAll();
    }


    @Transactional
    public List<EventTicket> createEvent(EventRequest eventRequest) {

        EventTicket event = eventDto.mapToEvent(eventRequest);
        EventCategory category = categoryRepository.findById(eventRequest.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("CategoryId",
                        "CategoryId", eventRequest.getCategoryId()));
        AddressRequest addressRequest = addressDto.mapToAddressRequest(eventRequest);
        Address address = addressDto.mapToAddress(addressRequest);

        address = addressRepository.save(address);

//        addressService.create(addressRequest);

        event.setEventCategory(category);
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


        BookedUserDetails bookedUserDetails = new BookedUserDetails();
        for (BookedUsersRequest userDetails : bookedEventsRequest.getUserDetails()) {

            EventTicket id = new EventTicket();

            id.setId(userDetails.getEventId());
            bookedEvents.setEventTicket(id);

            bookedUserDetails.setEventid(bookedEvents);
            bookedUserDetails.setName(userDetails.getName());
            bookedUserDetails.setAge(userDetails.getAge());
            bookedUserDetails.setGender(userDetails.getGender());

        }
        List<BookedUserDetails> userDetailsList= Collections.singletonList(bookedUsedDetailsRepository.save(bookedUserDetails));

        bookedEvents.setUserDetails(userDetailsList);


        return bookedEvents;
    }
}
