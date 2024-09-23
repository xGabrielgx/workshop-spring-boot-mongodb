package com.springbootmongodb.course.services;


import com.springbootmongodb.course.domain.User;
import com.springbootmongodb.course.repository.UserRepository;
import com.springbootmongodb.course.services.servicesException.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    // autowired instância o objeto injeção de depedência automatica;
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id));
    }

}
