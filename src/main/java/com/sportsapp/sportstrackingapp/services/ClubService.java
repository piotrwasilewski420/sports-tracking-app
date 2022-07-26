package com.sportsapp.sportstrackingapp.services;

import com.sportsapp.sportstrackingapp.exceptions.AthleteNotFoundException;
import com.sportsapp.sportstrackingapp.exceptions.ClubNotFoundException;
import com.sportsapp.sportstrackingapp.models.Club;
import com.sportsapp.sportstrackingapp.repositories.AthleteRepository;
import com.sportsapp.sportstrackingapp.repositories.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClubService {
    private final ClubRepository clubRepository;
    private final AthleteRepository athleteRepository;

    public ClubService(ClubRepository clubRepository, AthleteRepository athleteRepository) {
        this.clubRepository = clubRepository;
        this.athleteRepository = athleteRepository;
    }

    public void addClub(Club club) {
        clubRepository.save(club);
    }

    public Collection<Club> getClubs() {
        return clubRepository.findAll();
    }

    public void addMember(Long clubId, Long athleteId) throws ClubNotFoundException, AthleteNotFoundException {
        clubRepository.findById(clubId)
                .orElseThrow(() -> new ClubNotFoundException(clubId))
                .getMembers()
                .add(athleteRepository.findById(athleteId)
                        .orElseThrow(() -> new AthleteNotFoundException(athleteId)));
    }
}
