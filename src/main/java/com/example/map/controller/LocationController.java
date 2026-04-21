package com.example.map.controller;
import com.example.map.model.Location;
import com.example.map.repository.LocationRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/locations")
@CrossOrigin
public class LocationController {

private final LocationRepository repo;

public LocationController(LocationRepository repo){
this.repo=repo;
}

@GetMapping
public List<Location> getAll(){
return repo.findAll();
}
}
