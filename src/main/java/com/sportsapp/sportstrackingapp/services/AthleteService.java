package com.sportsapp.sportstrackingapp.services;

import com.sportsapp.sportstrackingapp.exceptions.AthleteNotFoundException;
import com.sportsapp.sportstrackingapp.exceptions.ClubNotFoundException;
import com.sportsapp.sportstrackingapp.models.Athlete;
import com.sportsapp.sportstrackingapp.models.Club;
import com.sportsapp.sportstrackingapp.repositories.AthleteRepository;
import com.sportsapp.sportstrackingapp.repositories.ClubRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@Service
public class AthleteService {
    private final AthleteRepository athleteRepository;
    private final ClubRepository clubRepository;

    public AthleteService(AthleteRepository athleteRepository, ClubRepository clubRepository) {
        this.athleteRepository = athleteRepository;
        this.clubRepository = clubRepository;
    }

    public void addAthlete(Athlete athlete) {
        athleteRepository.save(athlete);
    }

    public Collection<Athlete> getAthletes() {
        return athleteRepository.findAll();
    }

    public Athlete getAthlete(Long id) throws AthleteNotFoundException {
        return athleteRepository.findById(id).orElseThrow(() -> new AthleteNotFoundException(id));
    }

    public void joinClub(@PathVariable Long athleteId, @PathVariable Long clubId) throws AthleteNotFoundException, ClubNotFoundException {
        Athlete athlete = athleteRepository.findById(athleteId).orElseThrow(() -> new AthleteNotFoundException(athleteId));
        Club club = clubRepository.findById(clubId).orElseThrow(() -> new ClubNotFoundException(clubId));
        athlete.addClub(club);
        athleteRepository.save(athlete);
    }
}
