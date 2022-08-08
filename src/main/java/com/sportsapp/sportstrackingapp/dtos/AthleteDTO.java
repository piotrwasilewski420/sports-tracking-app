package com.sportsapp.sportstrackingapp.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;

@Getter @Setter @RequiredArgsConstructor
public class AthleteDTO {
    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private String sex;
    private Double weight;
    private Double height;
    private ArrayList<Long> activitiesIds;
    private ArrayList<Long> clubsIds;
}