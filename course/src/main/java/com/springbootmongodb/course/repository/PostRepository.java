package com.springbootmongodb.course.repository;

import com.springbootmongodb.course.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    // query methods
    List<Post> findByTitleContainingIgnoreCase(String text);
}
