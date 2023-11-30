package com.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
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

    @Column(nullable = false, length = 100)
    private String title;

    private String image;

    @Column(nullable = false, length = 100)
    private String desc;

    @Column(nullable = false, length = 100)
    private Double price;

    @Column(nullable = false, length = 100)
    private Double totalAvailability;

    @Column(nullable = false, length = 100)
    private Double balance;

    @Column(nullable = false, length = 100)
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
