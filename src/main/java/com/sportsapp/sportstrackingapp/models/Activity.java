package com.sportsapp.sportstrackingapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter @Setter @Entity
@Table(name = "ACTIVITY")
public class Activity {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "Activity must have a type.")
    @Enumerated(EnumType.STRING)
    private Type type;

//    @NotNull(message = "Activity must have a start time.")
    private Timestamp startTime;

//    @NotNull(message = "Activity must have an end time.")
    private Timestamp endTime;

    @OneToMany
    @JoinColumn(name = "activity_id")
    private List<Comment> comments;
}
