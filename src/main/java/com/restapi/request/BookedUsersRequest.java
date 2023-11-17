package com.restapi.request;

import com.restapi.model.BookedEvents;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedUsersRequest {
    private Integer id;
    private Integer eventId;
    private String name;
    private String gender;
    private Double age;
}
