package com.sportsapp.sportstrackingapp.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @RequiredArgsConstructor
public class ClubDTO {
    private Long id;
    private String name;
    private List<Long> membersIds = new ArrayList<>();
}
