package com.restapi.service;

import com.restapi.dto.CategoryDto;
import com.restapi.model.EventCategory;
import com.restapi.repository.EventCategoryRepository;
import com.restapi.request.EventCategoryRequest;
import com.restapi.response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventCategoryService {

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    @Autowired
    private CategoryDto categoryDto;

    public CategoryResponse findall() {
        List<EventCategory> categories = eventCategoryRepository.findAll();
        return categoryDto.mapToCategoryResponse(categories);
    }

    public CategoryResponse create(EventCategoryRequest eventCategoryRequest) {
        EventCategory category = categoryDto.mapToCategory(eventCategoryRequest);
        eventCategoryRepository.save(category);
        return findall();
    }

    public CategoryResponse update(EventCategoryRequest eventCategoryRequest) {
        EventCategory category = categoryDto.mapToCategory(eventCategoryRequest);
        eventCategoryRepository.save(category);
        return findall();
    }

    public CategoryResponse deleteCategory(Long id) {
        eventCategoryRepository.deleteById(id);
        return findall();
    }


}
