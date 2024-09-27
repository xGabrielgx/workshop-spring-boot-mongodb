package com.springbootmongodb.course.resources;

import com.springbootmongodb.course.domain.Post;
import com.springbootmongodb.course.domain.User;
import com.springbootmongodb.course.dto.UserDTO;
import com.springbootmongodb.course.resources.util.URL;
import com.springbootmongodb.course.services.PostService;
import com.springbootmongodb.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value="text", defaultValue = "") String text,
            @RequestParam(value="minDate", defaultValue = "") String minDate,
            @RequestParam(value="maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text);
        LocalDateTime min= URL.convertDate(minDate, LocalDateTime.of(2018, 3, 19, 0, 0 , 0));
        LocalDateTime max= URL.convertDate(minDate, LocalDateTime.now());
        List<Post> list = service.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);

    }


}
