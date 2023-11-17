package com.restapi.repository;

import com.restapi.model.Address;
import com.restapi.model.BookedUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedUsedDetailsRepository extends JpaRepository<BookedUserDetails, Integer> {
}
