package com.codegym.case4.repository;


import com.codegym.case4.model.Author;
import com.codegym.case4.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepository extends PagingAndSortingRepository<Book, Long> {
    Iterable<Book> findAllByAuthor(Author author);

    Page<Book> findAllByTitleContaining(String title, Pageable pageable);
}
