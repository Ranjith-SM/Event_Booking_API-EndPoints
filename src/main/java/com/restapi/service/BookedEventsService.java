package com.restapi.service;

import com.restapi.dto.BookedDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.BookedEvents;
import com.restapi.repository.BookedEventsRepository;
import com.restapi.response.BookedEventsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookedEventsService {

    @Autowired
    private BookedEventsRepository bookedEventsRepository;

    @Autowired
    private BookedDto bookedDto;

    public List<BookedEventsResponse> getAllBookedEvents() {
        List<BookedEvents> bookedEvents = bookedEventsRepository.findAll();
        return bookedDto.mapToBookedEvent(bookedEvents);

    }

    public List<BookedEventsResponse> getUserEvents(Long userId) {
        List<BookedEvents> bookedEvents = bookedEventsRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId", userId));
        return bookedDto.mapToBookedEvent(bookedEvents);

    }
}
