package com.restapi.repository;

import com.restapi.model.EventTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.File;

@Repository
public interface EventTicketRepository extends JpaRepository<EventTicket, Integer> {

}
