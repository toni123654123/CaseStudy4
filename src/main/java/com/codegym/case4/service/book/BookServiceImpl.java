package com.codegym.case4.service.book;


import com.codegym.case4.model.Author;
import com.codegym.case4.model.Book;
import com.codegym.case4.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements MyBookService {
    @Autowired
    private MyBookRepository myBookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return myBookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return myBookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        myBookRepository.save(book);
    }

    @Override
    public void remove(Long id) {
        myBookRepository.deleteById(id);
    }

    @Override
    public Iterable<Book> findAllByAuthor(Author author) {
        return myBookRepository.findAllByAuthor(author);
//        return null;
    }

    @Override
    public Page<Book> findAllByTitelContaining(String title, Pageable pageable) {
        return myBookRepository.findAllByTitleContaining(title, pageable);
//        return null;
    }


}
