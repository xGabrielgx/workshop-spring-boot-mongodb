package com.springbootmongodb.course.repository;

import com.springbootmongodb.course.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    // metódo com @query para consultar direto com nomeclatura do MongoDB
    // ?0 primeiro parametro que vier no método
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

    // query methods
    List<Post> findByTitleContainingIgnoreCase(String text);
}
