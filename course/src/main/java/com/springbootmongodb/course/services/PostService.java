package com.springbootmongodb.course.services;

import com.springbootmongodb.course.domain.Post;
import com.springbootmongodb.course.repository.PostRepository;
import com.springbootmongodb.course.services.servicesException.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    // autowired instância o objeto injeção de depedência automatica;
    @Autowired
    private PostRepository repository;

    public List<Post> findAll() {
        return repository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }
}
