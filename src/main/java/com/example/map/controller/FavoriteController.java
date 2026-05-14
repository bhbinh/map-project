package com.example.map.controller;

import com.example.map.model.Favorite;
import com.example.map.repository.FavoriteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin("*")
public class FavoriteController {

    private final FavoriteRepository repo;

    public FavoriteController(FavoriteRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Favorite save(@RequestBody Favorite fav) {
        return repo.save(fav);
    }

    @GetMapping("/{username}")
    public List<Favorite> get(@PathVariable String username) {
        return repo.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
