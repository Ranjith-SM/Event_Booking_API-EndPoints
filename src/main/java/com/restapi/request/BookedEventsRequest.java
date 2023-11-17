package com.restapi.request;

import com.restapi.model.BookedUserDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedEventsRequest {

    private Integer id;

    @NotEmpty
    private int eventId;

    @NotEmpty
    private int userId;

    @NotEmpty
    private Integer count;

    @NotEmpty
    private List<BookedUsersRequest> userDetails;
}
