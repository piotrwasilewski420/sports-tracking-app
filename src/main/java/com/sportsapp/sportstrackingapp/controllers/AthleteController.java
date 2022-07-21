package com.sportsapp.sportstrackingapp.controllers;

import com.sportsapp.sportstrackingapp.models.Athlete;
import com.sportsapp.sportstrackingapp.services.AthleteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class AthleteController {
    private final AthleteService athleteService;

    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @PostMapping("/athletes")
    public ResponseEntity<Object> addAthlete(@Valid @RequestBody Athlete athlete) {
        athleteService.addAthlete(athlete);
        return ResponseEntity.ok("Athlete is valid.");
    }

    @GetMapping("/athletes")
    public Collection<Athlete> retrieveAllAthletes() {
        return athleteService.getAthletes();
    }
}
