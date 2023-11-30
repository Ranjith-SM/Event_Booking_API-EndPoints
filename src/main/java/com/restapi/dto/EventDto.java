package com.restapi.dto;

import com.restapi.model.EventTicket;
import com.restapi.request.EventRequest;
import com.restapi.response.EventResponse;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
        eventTicket.setImage(eventRequest.getImage());

        SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdate.parse(eventRequest.getEventDate());
            eventTicket.setEventDate(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
//        eventTicket.setEventDate(eventRequest.getEventDate());
        return eventTicket;
    }
}
