package com.restapi.response;

import com.restapi.model.AppUser;
import com.restapi.model.BookedUserDetails;
import com.restapi.model.EventTicket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedEventsResponse {
    private Integer id;
    private EventTicket eventTicket;
    private AppUser appUser;
    private Integer count;
    private String BookedAt;
    private List<BookedUserDetails> userDetails;
}
