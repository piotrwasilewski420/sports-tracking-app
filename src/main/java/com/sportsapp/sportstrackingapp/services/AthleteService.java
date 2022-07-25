package com.sportsapp.sportstrackingapp.services;

import com.sportsapp.sportstrackingapp.models.Athlete;
import com.sportsapp.sportstrackingapp.repositories.AthleteRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class AthleteService {
    private final AthleteRepository athleteRepository;

    public AthleteService(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public void addAthlete(Athlete athlete) {
        athleteRepository.save(athlete);
    }

    public Collection<Athlete> getAthletes() {
        return athleteRepository.findAll();
    }

    public Optional<Athlete> getAthlete(Long id) {
        return athleteRepository.findById(id);
    }
}
