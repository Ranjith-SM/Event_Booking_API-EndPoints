package com.restapi.repository;

import com.restapi.model.BookedEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookedEventsRepository extends JpaRepository<BookedEvents, Integer> {

    List<BookedEvents> findByEventTicketId(Integer eventTicketId);

    @Query("select e from BookedEvents e inner join e.appUser a where a.id=?1")
    Optional<List<BookedEvents>> findByUserId(Long id);
}
