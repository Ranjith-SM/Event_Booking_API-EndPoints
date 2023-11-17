package com.restapi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventCategoryRequest {

    @NotEmpty
    private Long id;

    @NotEmpty
    @Size(min = 4 , message = " category name must be more than 4 characters.")
    private String c_name;

    public EventCategoryRequest(String c_name) {
        this.c_name = c_name;
    }
}
