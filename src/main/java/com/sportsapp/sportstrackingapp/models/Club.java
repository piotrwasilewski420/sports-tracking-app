package com.sportsapp.sportstrackingapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @Entity
public class Club {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Club must have a name.")
    private String name;

    @ManyToMany(mappedBy = "clubs", fetch = FetchType.LAZY)
    private List<Athlete> members = new ArrayList<>();
}
