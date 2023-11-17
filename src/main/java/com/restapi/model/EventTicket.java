package com.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String desc;
    private Double price;
    private Double totalAvailability;
    private Double balance;
    private Date eventDate;

    @ManyToOne
    @JoinColumn(name = "c_id", referencedColumnName = "id")
    private EventCategory eventCategory;

    @OneToOne
    @JoinColumn(name = "a_id", referencedColumnName = "id")
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "eventTicket")
    private List<BookedEvents> bookedEvents;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;


}
