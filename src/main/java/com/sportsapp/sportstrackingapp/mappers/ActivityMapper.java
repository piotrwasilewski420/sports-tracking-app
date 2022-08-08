package com.sportsapp.sportstrackingapp.mappers;

import com.sportsapp.sportstrackingapp.dtos.ActivityDTO;
import com.sportsapp.sportstrackingapp.models.Activity;
import com.sportsapp.sportstrackingapp.models.Athlete;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.MappingConstants;
//import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ActivityMapper {
    @Mapping(source = "athlete", target = "athleteId", qualifiedByName = "athleteToId")
    ActivityDTO activityToActivityDTO(Activity activity);

//    ActivityMapper INSTANCE = Mappers.getMapper(ActivityMapper.class);

    @Named("athleteToId")
    static Long athleteToId(Athlete athlete) {
        return athlete.getId();
    }
}