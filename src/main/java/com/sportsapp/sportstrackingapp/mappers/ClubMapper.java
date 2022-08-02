package com.sportsapp.sportstrackingapp.mappers;

import com.sportsapp.sportstrackingapp.dtos.ClubDTO;
import com.sportsapp.sportstrackingapp.models.Athlete;
import com.sportsapp.sportstrackingapp.models.Club;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClubMapper {
    @Mapping(source = "members", target = "membersIds", qualifiedByName = "memberToId")
    ClubDTO clubToClubDTO(Club club);

    ClubMapper INSTANCE = Mappers.getMapper(ClubMapper.class);

    @Named("memberToId")
    static Long memberToId(Athlete athlete) {
        return athlete.getId();
    }
}
