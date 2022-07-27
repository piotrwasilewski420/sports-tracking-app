package com.sportsapp.sportstrackingapp.controllers;

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
        return ResponseEntity.ok().build();
    }

    @GetMapping("/clubs")
    public Collection<Club> retrieveAllClubs() {
        return clubService.getClubs();
    }

    @GetMapping("/clubs/{id}")
    public Club retrieveClub(@PathVariable Long id) throws ClubNotFoundException {
        return clubService.getClub(id);
    }

//    @PostMapping("/athletes/{athleteId}/clubs/{clubId}")
//    public ResponseEntity<Object> addMember (
//            @PathVariable Long athleteId,
//            @PathVariable Long clubId) throws AthleteNotFoundException, ClubNotFoundException {
//        clubService.addMember(athleteId, clubId);
//        return ResponseEntity.ok().build();
//    }
}
