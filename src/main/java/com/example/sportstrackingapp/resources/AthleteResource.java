package com.example.sportstrackingapp.resources;

import com.example.sportstrackingapp.entities.Athlete;
import com.example.sportstrackingapp.repositories.AthleteRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class AthleteResource {

    private final AthleteRepository athleteRepository;

    public AthleteResource(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    @GetMapping("/athletes")
    public List<Athlete> retrieveAllAthletes() {
        return athleteRepository.findAll();
    }

    @PostMapping("/athletes")
    public ResponseEntity<Object> addAthlete(@Valid @RequestBody Athlete athlete) {
        Athlete savedAthlete = athleteRepository.save(athlete);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedAthlete.getId()).toUri();

        return ResponseEntity.ok("Athlete is valid.");
    }
}
