package com.restapi.dto;

import com.restapi.model.Address;
import com.restapi.request.AddressRequest;
import com.restapi.request.EventRequest;
import com.restapi.response.AddressResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressDto {

    public AddressResponse mapToAddressResponse(List<Address> addressList) {
        return new AddressResponse(addressList);
    }

    public AddressRequest mapToAddressRequest(EventRequest eventAddress) {
        System.out.println(eventAddress.getAddress());
        AddressRequest address = new AddressRequest();
        if (eventAddress.getId() != null) {
            address.setId(eventAddress.getId());
        }
        address.setAddress(eventAddress.getAddress());
        address.setCity(eventAddress.getCity());
        address.setZipcode(Double.valueOf(eventAddress.getZipcode()));
//        address.setEvent_id(eventAddress.getId());
        System.out.println(eventAddress.getAddress());
        return address;
    }

    public Address mapToAddress(AddressRequest addressRequest) {
        Address address = new Address();
        if (addressRequest.getId() != null) {
            address.setId(addressRequest.getId());
        }
        address.setAddress(addressRequest.getAddress());
        address.setCity(addressRequest.getCity());
        address.setZipcode(addressRequest.getZipcode());
        return address;
    }
}

