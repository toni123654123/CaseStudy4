package com.codegym.case4.service;


import com.codegym.case4.model.Author;
import com.codegym.case4.repository.MyAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MyAuthorServiceImpl implements MyAuthorService {
    @Autowired
    private MyAuthorRepository myAuthorRepository;

    @Override
    public Iterable<Author> findAll() {
        return myAuthorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return myAuthorRepository.findById(id);
    }

    @Override
    public void save(Author author) {
        myAuthorRepository.save(author);
    }

    @Override
    public void remove(Long id) {
        myAuthorRepository.deleteById(id);
    }
}
