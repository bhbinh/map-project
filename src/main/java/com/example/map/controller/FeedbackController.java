package com.example.map.controller;

import com.example.map.model.Feedback;
import com.example.map.repository.FeedbackRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin("*")
public class FeedbackController {

    private final FeedbackRepository repo;

    public FeedbackController(FeedbackRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Feedback save(@RequestBody Feedback f) {
        return repo.save(f);
    }

    @GetMapping
    public List<Feedback> all() {
        return repo.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}