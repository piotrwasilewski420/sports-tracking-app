package com.sportsapp.sportstrackingapp.controllers;

import com.sportsapp.sportstrackingapp.exceptions.AthleteNotFoundException;
import com.sportsapp.sportstrackingapp.exceptions.ClubNotFoundException;
import com.sportsapp.sportstrackingapp.models.Club;
import com.sportsapp.sportstrackingapp.services.ClubService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ClubController {
    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @PostMapping("/clubs")
    public ResponseEntity<Object> addClub(@Valid @RequestBody Club club) {
        clubService.addClub(club);
        return ResponseEntity.ok("Club added.");
    }

    @GetMapping("/clubs")
    public Collection<Club> retrieveAllClubs() {
        return clubService.getClubs();
    }

    @PutMapping("/athletes/{athleteId}/clubs/{clubId}")
    public ResponseEntity<Object> addMember (
            @PathVariable Long clubId,
            @PathVariable Long athleteId) throws ClubNotFoundException, AthleteNotFoundException {
        clubService.addMember(clubId, athleteId);
        return ResponseEntity.ok().build();
    }
}
