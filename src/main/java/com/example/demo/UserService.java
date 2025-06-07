package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void save(User user){
        userRepository.save(user);
    }
    public User getByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
