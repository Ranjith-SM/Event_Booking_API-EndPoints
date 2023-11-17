package com.restapi.request;

import com.restapi.model.BookedEvents;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedUsersRequest {

    private Integer id;

    @NotEmpty
    private Integer eventId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String gender;

    @NotEmpty
    @Min(value = 15, message = "Age must be greater than 15")
    private Double age;
}
