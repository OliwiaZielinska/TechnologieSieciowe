package com.example.technologiesieciowelista1.Service;

import com.example.technologiesieciowelista1.entity.User;
import com.example.technologiesieciowelista1.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.token.key}")
    private String key;
    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public User save(User user) {//zaszyfrowanie hasła przed zapisaniem do bazy danych
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void deleteById(Integer userId) {
    }

    public Iterable<User> findAll() {
        return null;
    }
}