package com.codegym.case4.service;




import com.codegym.case4.model.Author;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface MyAuthorService {
    Iterable<Author> findAll();

    Optional<Author> findById(Long id);

    void save(Author author);

    void remove(Long id);

}
