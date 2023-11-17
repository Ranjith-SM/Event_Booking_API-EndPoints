package com.restapi.dto;

import com.restapi.model.EventCategory;
import com.restapi.request.EventCategoryRequest;
import com.restapi.response.CategoryResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryDto {

    public CategoryResponse mapToCategoryResponse(List<EventCategory> categories) {
        CategoryResponse categoryResponse = new CategoryResponse();

        ArrayList<EventCategoryRequest> categoryRequests = new ArrayList<>();
        for (EventCategory category : categories) {
            categoryRequests.add(new EventCategoryRequest(category.getId(), category.getC_name()));
        }

        categoryResponse.setCategories(categoryRequests);
        return categoryResponse;
    }

    public EventCategory mapToCategory(EventCategoryRequest categoryRequest) {
        EventCategory category = new EventCategory();
        if (categoryRequest.getId() != null) {
            category.setId(categoryRequest.getId());
        }
        category.setC_name(categoryRequest.getC_name());
        return category;
    }
}
