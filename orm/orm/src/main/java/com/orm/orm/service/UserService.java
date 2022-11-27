package com.orm.orm.service;

import com.orm.orm.entity.User;
import com.orm.orm.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void save(User user){
        userRepository.save(user);
    }
}
