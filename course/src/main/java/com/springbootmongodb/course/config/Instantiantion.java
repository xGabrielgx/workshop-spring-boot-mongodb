package com.springbootmongodb.course.config;

import com.springbootmongodb.course.domain.Post;
import com.springbootmongodb.course.domain.User;
import com.springbootmongodb.course.repository.PostRepository;
import com.springbootmongodb.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class Instantiantion implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, LocalDate.from(fmt.parse("20/03/2018")), "Partiu viagem", "Vou viajar para SP. Abraços!", maria);
        Post post2 = new Post(null, LocalDate.from(fmt.parse("22/03/2018")), "Bom Dia", "Acordei Feliz hoje", maria);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
