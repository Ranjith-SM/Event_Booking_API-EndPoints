package com.restapi.controller;

import com.restapi.response.BookedEventsResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.BookedEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/booked_events")
public class BookedEventsController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private BookedEventsService bookedEventsService;

    @GetMapping("/{userId}")
    public ResponseEntity<APIResponse> getUsersEvent(@PathVariable Long userId) {
        List<BookedEventsResponse> eventsResponseList = bookedEventsService.getUserEvents(userId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(eventsResponseList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
