package com.example.map.controller;

import com.example.map.model.User;
import com.example.map.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final UserRepository userRepo;

    public AuthController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/login")
    public User login(@RequestBody User req) {

        User user =
                userRepo.findByUsername(req.getUsername());

        if(user != null &&
                user.getPassword().equals(req.getPassword())) {

            return user;
        }

        return null;
    }

    @PostMapping("/register")
    public User register(@RequestBody User req) {

        req.setRole("USER");

        return userRepo.save(req);
    }
}
