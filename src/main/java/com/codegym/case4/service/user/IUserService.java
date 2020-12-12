package com.codegym.case4.service.user;


import com.codegym.case4.model.User;
import com.codegym.case4.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends  IGeneralService<User>, UserDetailsService {
    User findByUsername(String username);
    Page<User> findAllByNameContaining(String name, Pageable pageable);
}
