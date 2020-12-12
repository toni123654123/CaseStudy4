package com.codegym.case4.service.author;


import com.codegym.case4.model.Author;
import com.codegym.case4.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IAuthorServiceImpl implements IAuthorService {
    @Autowired
    private IAuthorRepository iAuthorRepository;

    @Override
    public Iterable<Author> findAll() {
        return iAuthorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return iAuthorRepository.findById(id);
    }

    @Override
    public void save(Author author) {
        iAuthorRepository.save(author);
    }

    @Override
    public void remove(Long id) {
        iAuthorRepository.deleteById(id);
    }
}
