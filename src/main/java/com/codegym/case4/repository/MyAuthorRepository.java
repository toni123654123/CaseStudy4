package com.codegym.case4.repository;



import com.codegym.case4.model.Author;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MyAuthorRepository extends PagingAndSortingRepository<Author, Long> {
}
