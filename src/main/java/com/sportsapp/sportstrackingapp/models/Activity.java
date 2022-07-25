package com.sportsapp.sportstrackingapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter @Setter @Entity
@Table(name = "ACTIVITY")
public class Activity {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Activity must have a type.")
    private String type;

    @ManyToOne
    @JoinColumn(name = "athlete_id", insertable = false, updatable = false)
    private Athlete athlete;

    @OneToMany
    @JoinColumn(name = "activity_id")
    private Collection<Comment> comments;
}
