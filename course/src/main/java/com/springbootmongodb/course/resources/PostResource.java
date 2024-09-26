package com.springbootmongodb.course.resources;

import com.springbootmongodb.course.domain.Post;
import com.springbootmongodb.course.domain.User;
import com.springbootmongodb.course.dto.UserDTO;
import com.springbootmongodb.course.services.PostService;
import com.springbootmongodb.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    // injetando o UserService;
    @Autowired
    private PostService service;


    @GetMapping
    public ResponseEntity<List<Post>> findAll() {
        List<Post> posts = service.findAll();
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
