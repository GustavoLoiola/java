package com.users.crud.service;

import com.users.crud.entity.User;
import com.users.crud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
       return repository.save(user);
    }

    public List<User> findAll(){
       return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public User update(Long id, User user) {
        User userToUpdate = repository.findById(id).orElseThrow();

        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setBirthDate(user.getBirthDate());

        return repository.save(userToUpdate);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
