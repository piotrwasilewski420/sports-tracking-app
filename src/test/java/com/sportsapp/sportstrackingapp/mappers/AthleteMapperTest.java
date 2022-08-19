package com.sportsapp.sportstrackingapp.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sportsapp.sportstrackingapp.dtos.AthleteDTO;
import com.sportsapp.sportstrackingapp.models.Athlete;
import com.sportsapp.sportstrackingapp.models.Club;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AthleteMapperTest {
    @Test
    @DisplayName("Mapping Athlete to AthleteDTO with club membership should work")
    public void testMappingObjectToId() {
        Athlete athlete = new Athlete();

        List<Club> clubs = new ArrayList<>();

        Club club = new Club();
        club.setId(1L);

        List<Athlete> members = new ArrayList<>();
        members.add(athlete);

        club.setMembers(members);

        clubs.add(club);

        athlete.setClubs(clubs);

        List<Long> clubsIds = new ArrayList<>();
        clubsIds.add(1L);

        AthleteDTO athleteDTO = AthleteMapper.INSTANCE.athleteToAthleteDTO(athlete);
        assertEquals(clubsIds, athleteDTO.getClubsIds());
    }
}
