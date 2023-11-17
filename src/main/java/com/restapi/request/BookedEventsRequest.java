package com.restapi.request;

import com.restapi.model.BookedUserDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedEventsRequest {

    private Integer id;
    private int eventId;
    private int userId;
    private Integer count;
    private List<BookedUsersRequest> userDetails;
}
