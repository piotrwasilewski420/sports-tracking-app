package com.sportsapp.sportstrackingapp.services;

import com.sportsapp.sportstrackingapp.dtos.ClubDTO;
import com.sportsapp.sportstrackingapp.exceptions.ClubNotFoundException;
import com.sportsapp.sportstrackingapp.mappers.ClubMapper;
import com.sportsapp.sportstrackingapp.models.Club;
import com.sportsapp.sportstrackingapp.repositories.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ClubService {
    private final ClubRepository clubRepository;

    private final ClubMapper clubMapper;

    public ClubService(ClubRepository clubRepository, ClubMapper clubMapper) {
        this.clubRepository = clubRepository;
        this.clubMapper = clubMapper;
    }

    public void addClub(Club club) {
        clubRepository.save(club);
    }

    public Collection<ClubDTO> getClubs() {
        Collection<Club> clubs = clubRepository.findAll();

        return clubs.stream()
                .map(ClubMapper.INSTANCE::clubToClubDTO)
                .collect(Collectors.toList());
    }

    public ClubDTO getClub(Long id) throws ClubNotFoundException {
        Club club = clubRepository.findById(id).orElseThrow(() -> new ClubNotFoundException(id));
        return clubMapper.INSTANCE.clubToClubDTO(club);
    }
}
