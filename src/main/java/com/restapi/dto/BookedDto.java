package com.restapi.dto;

import com.restapi.model.BookedEvents;
import com.restapi.model.BookedUserDetails;
import com.restapi.response.BookedEventsResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookedDto {

    public List<BookedEventsResponse> mapToBookedEvent(List<BookedEvents> bookedEvents) {
        List<BookedEventsResponse> bookedEventsResponseList = new ArrayList<>();

        for (BookedEvents event:bookedEvents) {
            BookedEventsResponse bookedEventsResponse = new BookedEventsResponse();
            bookedEventsResponse.setId(event.getId());
            bookedEventsResponse.setEventTicket(event.getEventTicket());
            bookedEventsResponse.setAppUser(event.getAppUser());
            bookedEventsResponse.setCount(event.getCount());

            System.out.println(event.getUserDetails());
            bookedEventsResponse.setUserDetails(event.getUserDetails());

            System.out.println(bookedEventsResponse.getUserDetails());
            bookedEventsResponseList.add(bookedEventsResponse);
        }

        return bookedEventsResponseList;

    }
}
