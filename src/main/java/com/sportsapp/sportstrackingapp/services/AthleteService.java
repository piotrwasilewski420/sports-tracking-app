package com.sportsapp.sportstrackingapp.services;

import com.sportsapp.sportstrackingapp.dtos.AthleteDTO;
import com.sportsapp.sportstrackingapp.exceptions.AthleteNotFoundException;
import com.sportsapp.sportstrackingapp.exceptions.ClubNotFoundException;
import com.sportsapp.sportstrackingapp.mappers.AthleteMapper;
import com.sportsapp.sportstrackingapp.models.Athlete;
import com.sportsapp.sportstrackingapp.models.Club;
import com.sportsapp.sportstrackingapp.repositories.AthleteRepository;
import com.sportsapp.sportstrackingapp.repositories.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AthleteService {
    private final AthleteMapper athleteMapper;
    private final AthleteRepository athleteRepository;
    private final ClubRepository clubRepository;

    public AthleteService(AthleteMapper athleteMapper, AthleteRepository athleteRepository, ClubRepository clubRepository) {
        this.athleteMapper = athleteMapper;
        this.athleteRepository = athleteRepository;
        this.clubRepository = clubRepository;
    }

    public void addAthlete(Athlete athlete) {
        athleteRepository.save(athlete);
    }

    public Collection<AthleteDTO> getAthletes() {
        Collection<Athlete> athletes = athleteRepository.findAll();

        return athletes.stream()
                .map(AthleteMapper.INSTANCE::athleteToAthleteDTO)
                .collect(Collectors.toList());
    }

    public AthleteDTO getAthlete(Long id) throws AthleteNotFoundException {
        Athlete athlete = athleteRepository.findById(id).orElseThrow(() -> new AthleteNotFoundException(id));
        return athleteMapper.INSTANCE.athleteToAthleteDTO(athlete);
    }

    public void joinClub(Long athleteId, Long clubId) throws AthleteNotFoundException, ClubNotFoundException {
        Athlete athlete = athleteRepository.findById(athleteId).orElseThrow(() -> new AthleteNotFoundException(athleteId));
        Club club = clubRepository.findById(clubId).orElseThrow(() -> new ClubNotFoundException(clubId));

        athlete.addClub(club);

        athleteRepository.save(athlete);
    }
}
