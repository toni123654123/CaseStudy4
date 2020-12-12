package com.codegym.case4.service.user;


import com.codegym.case4.model.User;
import com.codegym.case4.model.UserPrinciple;
import com.codegym.case4.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {


    @Autowired
    private IUserRepository userRepository;


    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAllByIsDeletedFalse(pageable);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        userRepository.remove(id);
    }

    @Override
    public Page<User> findAllByNameContaining(String name, Pageable pageable) {
        return userRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return UserPrinciple.build(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUserName(username);
    }

}
