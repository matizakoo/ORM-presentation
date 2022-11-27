package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void save(User user){
        userRepository.save(user);
    }

    public ArrayList<User> listOfUsers(){
        return (ArrayList<User>) userRepository.findAll();
    }
}
