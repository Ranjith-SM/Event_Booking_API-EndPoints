package com.restapi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRequest {

    private Integer id;

    @NotEmpty
    @Size(min = 3, message = "Title should be more than 3 characters")
    private String title;

    @NotEmpty
    @Size(min = 15, message = "Title should be more than 15 characters")
    private String desc;

    @NotEmpty
    @Positive
    private Double price;

    @NotEmpty
    @Positive
    private Double totalAvailability;

    @NotEmpty
    @Positive
    private Double balance;

    @NotEmpty
    private String eventDate;

    @NotEmpty
    @Positive
    private Long categoryId;

    @NotEmpty
    @Size(min = 10, message = "please enter clear & full address")
    private String address;

    @NotEmpty
    @Size(min = 3, message = "please enter correct city")
    private String city;

    @NotEmpty
    @Size(min = 5, message = "please enter full zip-code")
    private String zipcode;
}
