package com.example.LibraryGrok.service;


import com.example.LibraryGrok.model.User;
import com.example.LibraryGrok.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User addUser(User user){
        return repo.save(user);
    }

    public List<User> getAllUsers(){
        return repo.findAll();
    }
}
