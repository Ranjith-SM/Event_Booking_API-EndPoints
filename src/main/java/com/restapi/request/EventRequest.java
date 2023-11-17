package com.restapi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
    private Integer id;
    private String title;
    private String desc;
    private Double price;
    private Double totalAvailability;
    private Double balance;
    private LocalDateTime localDateTime;
    private Long categoryId;
    private String address;
    private String city;
    private String zipcode;
}
