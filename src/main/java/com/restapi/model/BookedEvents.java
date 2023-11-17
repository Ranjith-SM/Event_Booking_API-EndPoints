package com.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookedEvents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="event_id",referencedColumnName = "id")
    private EventTicket eventTicket;

    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private AppUser appUser;

    private Integer count;

    @OneToMany(mappedBy ="eventid")
    private List<BookedUserDetails> userDetails;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

}
