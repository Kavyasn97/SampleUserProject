package com.userApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.userApp.entity.User;
import com.userApp.repository.UserRepository;


@Service
public class UserService {
	
    @Autowired
    private UserRepository userRepository;

    public User signup(User user) {
        // Perform necessary validation and hashing of the password before saving.
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public boolean forgotPassword(String email, String newPassword) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            // Update the password
            user.setPassword(newPassword);
            userRepository.save(user);
            return true;
        }
        return false;
    }
    
   
    
}
