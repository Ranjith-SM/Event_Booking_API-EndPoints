package com.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

    @Id
    @GeneratedValue
    private Integer id;

    private String address;

    private String city;

    private Double zipcode;

    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private EventTicket eventTicket;
}
