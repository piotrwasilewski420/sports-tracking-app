package com.sportsapp.sportstrackingapp.controllers;

import com.sportsapp.sportstrackingapp.models.Club;
import com.sportsapp.sportstrackingapp.services.ClubService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
