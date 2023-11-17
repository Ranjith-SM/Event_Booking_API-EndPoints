package com.restapi.dto;

import com.restapi.model.EventTicket;
import com.restapi.request.EventRequest;
import com.restapi.response.EventResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventDto {

    public EventResponse mapToEventResponse(List<EventTicket> eventTicket) {
        return new EventResponse(eventTicket);
    }

    public EventTicket mapToEvent(EventRequest eventRequest) {
        EventTicket eventTicket = new EventTicket();
        if (eventRequest.getId() != null) {
            eventTicket.setId(eventRequest.getId());
        }
        eventTicket.setTitle(eventRequest.getTitle());
        eventTicket.setDesc(eventRequest.getDesc());
        eventTicket.setPrice(eventRequest.getPrice());
        eventTicket.setTotalAvailability(eventRequest.getTotalAvailability());
        eventTicket.setBalance(eventRequest.getBalance());

        return eventTicket;
    }
}
