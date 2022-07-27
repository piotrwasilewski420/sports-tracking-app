package com.sportsapp.sportstrackingapp.services;

import com.sportsapp.sportstrackingapp.exceptions.ClubNotFoundException;
import com.sportsapp.sportstrackingapp.models.Club;
import com.sportsapp.sportstrackingapp.repositories.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClubService {
    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public void addClub(Club club) {
        clubRepository.save(club);
    }

    public Collection<Club> getClubs() {
        return clubRepository.findAll();
    }

    public Club getClub(Long id) throws ClubNotFoundException {
        return clubRepository.findById(id).orElseThrow(() -> new ClubNotFoundException(id));
    }

//    public Club addMember(@PathVariable Long athleteId, @PathVariable Long clubId) throws ClubNotFoundException, AthleteNotFoundException {
//        Club club = clubRepository.findById(clubId).orElseThrow(() -> new ClubNotFoundException(clubId));
//        Athlete athlete = athleteRepository.findById(athleteId).orElseThrow(() -> new AthleteNotFoundException(athleteId));
//        club.addMember(athlete);
//        return clubRepository.save(club);
//    }
}
