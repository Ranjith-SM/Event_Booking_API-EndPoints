package com.restapi.request;

import com.restapi.model.EventTicket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    private Integer id;

    @NotEmpty
    @Size(min = 10, message = "please enter clear & full address")
    private String address;

    @NotEmpty
    @Size(min = 3 , message = "please enter correct city")
    private String city;

    @NotEmpty
    @Size(min = 5 , message = "please enter full zip-code")
    private Double zipcode;

    @NotEmpty
    private int event_id;


}
