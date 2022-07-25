package com.sportsapp.sportstrackingapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter @Setter @Entity
public class Club {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Club must have a name.")
    private String name;

    @ManyToMany
    private Collection<Athlete> members;
}
