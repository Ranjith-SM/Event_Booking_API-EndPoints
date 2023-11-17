package com.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String address;

    private String city;

    private Double zipcode;

    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private EventTicket eventTicket;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
