package com.restapi.request;

import com.restapi.model.EventTicket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    private Integer id;

    private String address;

    private String city;

    private Double zipcode;

    private int event_id;


}
