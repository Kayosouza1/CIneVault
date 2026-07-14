package com.java.kayo.cinevault.service;

import com.java.kayo.cinevault.Entity.User;
import com.java.kayo.cinevault.repository.UserRepository;
import com.java.kayo.cinevault.request.UserRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

private final UserRepository userRepository;
private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User save(@RequestBody User user){
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);

    }

}
