package com.restapi.repository;

import com.restapi.model.EventTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EventTicketRepository extends JpaRepository<EventTicket, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE EventTicket e SET e.totalAvailability = e.totalAvailability - :count WHERE e.id = :id")
    void updateTickets(@Param("count") Double count,@Param("id") Integer id);
}
