package com.codegym.case4.service;


import com.codegym.case4.model.Author;
import com.codegym.case4.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface MyBookService {
    Page<Book> findAll(Pageable pageable);

    Optional<Book> findById(Long id);

    void save(Book book);

    void remove(Long id);

    Iterable<Book> findAllByAuthor(Author author);

    Page<Book> findAllByTitelContaining(String title, Pageable pageable);
}
