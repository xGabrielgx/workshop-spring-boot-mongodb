package com.springbootmongodb.course.config;

import com.springbootmongodb.course.domain.Post;
import com.springbootmongodb.course.domain.User;
import com.springbootmongodb.course.dto.AuthorDTO;
import com.springbootmongodb.course.dto.CommentDTO;
import com.springbootmongodb.course.repository.PostRepository;
import com.springbootmongodb.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class Instantiantion implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.of("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        // primeiro salva os usuários antes associar
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

                                                                    // new AuthorDTO(maria aqui fazer a persistencia do objto
        Post post1 = new Post(null, LocalDateTime.from(fmt.parse("21/03/2018 00:00:00")), "Partiu viagem", "Vou viajar para SP. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, LocalDateTime.from(fmt.parse("23/03/2018 00:00:00")), "Bom Dia", "Acordei Feliz hoje", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", LocalDateTime.from(fmt.parse("21/03/2018 00:00:00")), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", LocalDateTime.from(fmt.parse("22/03/2018 00:00:00")), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótido dia!", LocalDateTime.from(fmt.parse("23/03/2018 00:00:00")), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
