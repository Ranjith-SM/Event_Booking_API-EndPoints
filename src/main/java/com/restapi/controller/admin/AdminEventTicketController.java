package com.restapi.controller.admin;

import com.restapi.model.EventTicket;
import com.restapi.request.EventCategoryRequest;
import com.restapi.request.EventRequest;
import com.restapi.response.CategoryResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.EventCategoryService;
import com.restapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/event")
public class AdminEventTicketController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private EventService eventService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllEvents() {
        List<EventTicket> eventsList = eventService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(eventsList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APIResponse> createEvent(@RequestBody EventRequest eventRequest) {
        List<EventTicket> eventList = eventService.createEvent(eventRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(eventList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<APIResponse> updateEvent(@RequestBody EventRequest eventRequest) {
        List<EventTicket> eventList = eventService.updateEvent(eventRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(eventList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteEvent(@PathVariable Integer id) {
        List<EventTicket> eventList = eventService.deleteById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(eventList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }
}
