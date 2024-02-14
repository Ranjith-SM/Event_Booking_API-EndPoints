package com.restapi.controller;

import com.restapi.dto.BookedDto;
import com.restapi.model.EventTicket;
import com.restapi.request.BookedEventsRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/event")
public class EventTicketController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private EventService eventService;

    @Autowired
    private BookedDto bookedDto;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllEvents() {
        List<EventTicket> eventsList = eventService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(eventsList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APIResponse> bookEvents(@RequestBody BookedEventsRequest bookedEventsRequest) {
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(eventService.bookEvents(bookedEventsRequest));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
