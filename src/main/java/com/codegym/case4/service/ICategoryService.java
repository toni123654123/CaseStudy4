package com.codegym.case4.service;

import com.codegym.case4.model.Author;
import com.codegym.case4.model.Category;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface ICategoryService{
    Iterable<Category> findAll();

    Optional<Category> findById(Long id);

    void save(Category category);

    void remove(Long id);
}
