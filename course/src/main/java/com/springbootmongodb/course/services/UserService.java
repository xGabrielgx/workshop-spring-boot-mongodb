package com.springbootmongodb.course.services;


import com.springbootmongodb.course.domain.User;
import com.springbootmongodb.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    // autowired instância o objeto injeção de depedência automatica;
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

}
