package com.example.technologiesieciowelista1.controllers;

import com.example.technologiesieciowelista1.Service.UserService;
import com.example.technologiesieciowelista1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody User addUser(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable Integer userId){
        userService.deleteById(userId);
    }
    @GetMapping("/getAll")
    public @ResponseBody Iterable<User> getAllUser(){
        return userService.findAll();
    }
}
