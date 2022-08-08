package com.sportsapp.sportstrackingapp.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter @RequiredArgsConstructor
public enum Type {
    WALK ("WALK"),
    RUN ("RUN"),
    BIKE ("BIKE"),
    SWIM ("SWIM");

    private final String type;
}
