package com.sportsapp.sportstrackingapp.controllers;

import com.sportsapp.sportstrackingapp.dtos.AthleteDTO;
import com.sportsapp.sportstrackingapp.exceptions.ActivityNotFoundException;
import com.sportsapp.sportstrackingapp.exceptions.AthleteNotFoundException;
import com.sportsapp.sportstrackingapp.exceptions.ClubNotFoundException;
import com.sportsapp.sportstrackingapp.models.Athlete;
import com.sportsapp.sportstrackingapp.services.AthleteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok().build();
    }

    @GetMapping("/athletes")
    public Collection<AthleteDTO> retrieveAllAthletes() {
        return athleteService.getAthletes();
    }

    @GetMapping("/athletes/{id}")
    public AthleteDTO retrieveAthlete(@PathVariable Long id) throws AthleteNotFoundException {
        return athleteService.getAthlete(id);
    }

    @PostMapping("/athletes/{athleteId}/clubs/{clubId}")
    public ResponseEntity<Object> joinClub(
            @PathVariable Long athleteId,
            @PathVariable Long clubId) throws AthleteNotFoundException, ClubNotFoundException {
        athleteService.joinClub(athleteId, clubId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/athletes/{athleteId}/activities/{activityId}")
    public ResponseEntity<Object> addActivity(
            @PathVariable Long athleteId,
            @PathVariable Long activityId) throws AthleteNotFoundException, ActivityNotFoundException {
        athleteService.addActivity(athleteId, activityId);
        return ResponseEntity.ok().build();
    }
}
