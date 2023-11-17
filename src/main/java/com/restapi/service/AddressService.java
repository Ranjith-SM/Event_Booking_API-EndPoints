package com.restapi.service;

import com.restapi.dto.AddressDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.Address;
import com.restapi.model.EventTicket;
import com.restapi.repository.AddressRepository;
import com.restapi.repository.EventTicketRepository;
import com.restapi.request.AddressRequest;
import com.restapi.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private EventTicketRepository eventTicketRepository;

    @Autowired
    private AddressDto addressDto;

    public AddressResponse findAll() {
        List<Address> addressList = addressRepository.findAll();
        return addressDto.mapToAddressResponse(addressList);
    }

    public AddressResponse create(AddressRequest addressRequest) {
        Address address = addressDto.mapToAddress(addressRequest);

        EventTicket event = eventTicketRepository.findById(addressRequest.getEvent_id())
                .orElseThrow(() -> new ResourceNotFoundException("eventId", "eventId",
                        addressRequest.getEvent_id()));
        address.setEventTicket(event);
        addressRepository.save(address);
        return findAll();
    }

    public AddressResponse update(AddressRequest addressRequest) {
        Address address = addressDto.mapToAddress(addressRequest);

        EventTicket event = eventTicketRepository.findById(addressRequest.getEvent_id())
                .orElseThrow(() -> new ResourceNotFoundException("eventId", "eventId",
                        addressRequest.getEvent_id()));
        address.setEventTicket(event);
        addressRepository.save(address);
        return findAll();
    }


}
