package com.sportsapp.sportstrackingapp.mappers;

import com.sportsapp.sportstrackingapp.dtos.AthleteDTO;
import com.sportsapp.sportstrackingapp.models.Activity;
import com.sportsapp.sportstrackingapp.models.Athlete;
import com.sportsapp.sportstrackingapp.models.Club;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AthleteMapper {
    @Mapping(source = "clubs", target = "clubsIds", qualifiedByName = "clubToId")
    @Mapping(source = "activities", target = "activitiesIds", qualifiedByName = "activityToId")
    AthleteDTO athleteToAthleteDTO(Athlete athlete);

    AthleteMapper INSTANCE = Mappers.getMapper(AthleteMapper.class);

    @Named("clubToId")
    static Long clubToId(Club club) {
        return club.getId();
    }

    @Named("activityToId")
    static Long activityToId(Activity activity) {
        return activity.getId();
    }


}

