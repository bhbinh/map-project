package com.example.map.controller;

import com.example.map.repository.*;
import com.example.map.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    private final UserRepository userRepo;
    private final FavoriteRepository favoriteRepo;
    private final FeedbackRepository feedbackRepo;

    public AdminController(
            UserRepository userRepo,
            FavoriteRepository favoriteRepo,
            FeedbackRepository feedbackRepo
    ) {
        this.userRepo = userRepo;
        this.favoriteRepo = favoriteRepo;
        this.feedbackRepo = feedbackRepo;
    }

    @GetMapping("/stats")
    public Map<String, Object> stats() {

        Map<String, Object> map = new HashMap<>();

        map.put("users", userRepo.count());
        map.put("favorites", favoriteRepo.count());
        map.put("feedbacks", feedbackRepo.count());

        return map;
    }

    @GetMapping("/users")
    public List<User> users() {
        return userRepo.findAll();
    }

    @PutMapping("/users/{id}")
    public User update(
            @PathVariable Long id,
            @RequestBody User req
    ) {

        User u = userRepo.findById(id).orElseThrow();

        u.setUsername(req.getUsername());
        u.setPassword(req.getPassword());

        return userRepo.save(u);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Long id) {
        userRepo.deleteById(id);
    }
}