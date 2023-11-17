package com.restapi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventCategoryRequest {
    private Long id;
    private String c_name;

    public EventCategoryRequest(String c_name) {
        this.c_name = c_name;
    }
}
