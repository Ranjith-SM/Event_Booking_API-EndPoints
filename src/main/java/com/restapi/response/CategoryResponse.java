package com.restapi.response;

import com.restapi.request.EventCategoryRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryResponse {
    private List<EventCategoryRequest> categories = new ArrayList<>();

}
