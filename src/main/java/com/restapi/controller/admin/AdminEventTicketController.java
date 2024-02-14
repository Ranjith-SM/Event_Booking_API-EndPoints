package com.restapi.controller.admin;

import com.restapi.model.EventTicket;
import com.restapi.request.EventCategoryRequest;
import com.restapi.request.EventRequest;
import com.restapi.request.UpdateRequest;
import com.restapi.response.CategoryResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.EventCategoryService;
import com.restapi.service.EventService;
import com.restapi.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/admin/event")
public class AdminEventTicketController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private EventService eventService;
    @Autowired
    private StorageService storageService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllEvents() {
        List<EventTicket> eventsList = eventService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(eventsList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<APIResponse> createEvent(@RequestParam("image")MultipartFile image ,
                                                   @RequestParam("categoryId") Long categoryId,
                                                   @RequestParam("title") String title,
                                                   @RequestParam("desc") String desc,
                                                   @RequestParam("price") Double price,
                                                   @RequestParam("totalAvailability") Double totalAvailability,
                                                   @RequestParam("balance") Double balance,
                                                   @RequestParam("eventDate") String eventDate,
                                                   @RequestParam("address") String address,
                                                   @RequestParam("city") String city,
                                                   @RequestParam("zipcode") String zipcode
                                                   ) throws IOException {

        String file = storageService.storeFile(image);

        EventRequest eventRequest = new EventRequest();
        eventRequest.setTitle(title);
        eventRequest.setDesc(desc);
        eventRequest.setImage(file);
        eventRequest.setPrice(price);
        eventRequest.setTotalAvailability(totalAvailability);
        eventRequest.setBalance(balance);
        eventRequest.setEventDate(eventDate);
        eventRequest.setCategoryId(categoryId);
        eventRequest.setAddress(address);
        eventRequest.setCity(city);
        eventRequest.setZipcode(zipcode);

        List<EventTicket> eventList = eventService.createEvent(eventRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(eventList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<APIResponse> updateEvent(@RequestParam("id") Integer id,
                                                   @RequestParam("categoryId") Long categoryId,
                                                   @RequestParam("title") String title,
                                                   @RequestParam("desc") String desc,
                                                   @RequestParam("price") Double price,
                                                   @RequestParam("totalAvailability") Double totalAvailability,
                                                   @RequestParam("balance") Double balance,
                                                   @RequestParam("eventDate") String eventDate,
                                                   @RequestParam("address") String address,
                                                   @RequestParam("city") String city,
                                                   @RequestParam("zipcode") String zipcode) {

        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.setId(id);
        updateRequest.setTitle(title);
        updateRequest.setDesc(desc);
        updateRequest.setPrice(price);
        updateRequest.setEventDate(eventDate);
        updateRequest.setTotalAvailability(totalAvailability);
        updateRequest.setBalance(balance);
        updateRequest.setCategoryId(categoryId);
        updateRequest.setAddress(address);
        updateRequest.setCity(city);
        updateRequest.setZipcode(zipcode);
        List<EventTicket> eventList = eventService.updateEvent(updateRequest);
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
