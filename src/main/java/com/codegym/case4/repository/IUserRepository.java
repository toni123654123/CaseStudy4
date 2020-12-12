package com.codegym.case4.repository;


import com.codegym.case4.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {
    User findByUserName(String username);

    Page<User> findAllByIsDeletedFalse(Pageable pageable);

    @Query(value="select * from users u where u.name LIKE concat('%',:name,'%') and u.isDeleted = 0",nativeQuery = true)
    Page<User> findAllByNameContaining(@Param("name") String name, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE users u set isDeleted =1 where u.userId = :id", nativeQuery = true)
    void remove(@Param("id") Long id);

//    Page<User> findAllByNameContainingAndDeletedIsFalse(String name, Pageable pageable);
//    Page<User> findAllByNameContaining(String name, Pageable pageable);
}
