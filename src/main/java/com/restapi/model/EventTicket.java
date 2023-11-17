package com.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventTicket {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;
    private String desc;
    private Double price;
    private Double totalAvailability;
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "c_id", referencedColumnName = "id")
    private EventCategory eventCategory;

    @OneToOne
    @JoinColumn(name = "a_id", referencedColumnName = "id")
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "eventTicket")
    private List<BookedEvents> bookedEvents;


}
