package com.sportsapp.sportstrackingapp.services;

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
}
