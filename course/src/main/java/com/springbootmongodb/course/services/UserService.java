package com.springbootmongodb.course.services;

import com.springbootmongodb.course.domain.User;
import com.springbootmongodb.course.dto.UserDTO;
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

    public User insert (User obj) {
        return repository.insert(obj);
    }

    public void delete(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ObjectNotFoundException(id);
        }
    }

    public User update(User obj) {
            User newObj = findById(obj.getId());
            updateDate(newObj, obj);
            return repository.save(newObj);

    }

    private void updateDate(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

}
