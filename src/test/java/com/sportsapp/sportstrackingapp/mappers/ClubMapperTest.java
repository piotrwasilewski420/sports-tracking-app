package com.sportsapp.sportstrackingapp.mappers;

import com.sportsapp.sportstrackingapp.dtos.ClubDTO;
import com.sportsapp.sportstrackingapp.models.Athlete;
import com.sportsapp.sportstrackingapp.models.Club;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClubMapperTest {
    @Test
    @DisplayName("Mapping Club to ClubDTO with athlete membership should work")
    public void testMappingObjectToId() {
        Club club = new Club();

        List<Athlete> athletes = new ArrayList<>();

        Athlete athlete = new Athlete();
        athlete.setId(1L);

        List<Club> clubs = new ArrayList<>();
        clubs.add(club);

        athlete.setClubs(clubs);

        athletes.add(athlete);

        club.setMembers(athletes);

        List<Long> athletesIds = new ArrayList<>();
        athletesIds.add(1L);

        ClubDTO clubDTO = ClubMapper.INSTANCE.clubToClubDTO(club);
        assertEquals(athletesIds, clubDTO.getMembersIds());
    }
}
