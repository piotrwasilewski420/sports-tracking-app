package com.sportsapp.sportstrackingapp.services;

import com.sportsapp.sportstrackingapp.dtos.ClubDTO;
import com.sportsapp.sportstrackingapp.exceptions.ClubNotFoundException;
import com.sportsapp.sportstrackingapp.mappers.ClubMapper;
import com.sportsapp.sportstrackingapp.models.Club;
import com.sportsapp.sportstrackingapp.repositories.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

        List<ClubDTO> clubsDTO = new ArrayList<>();
        for (Club club : clubs ) {
            clubsDTO.add(clubMapper.INSTANCE.clubToClubDTO(club));
        }

        return clubsDTO;
    }

    public ClubDTO getClub(Long id) throws ClubNotFoundException {
        Club club = clubRepository.findById(id).orElseThrow(() -> new ClubNotFoundException(id));
        return clubMapper.INSTANCE.clubToClubDTO(club);
    }
}
