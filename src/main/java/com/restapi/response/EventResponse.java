package com.restapi.response;

import com.restapi.model.EventTicket;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class EventResponse {
    private List<EventTicket> eventTicketList;
}
