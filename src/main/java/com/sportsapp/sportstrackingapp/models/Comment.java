package com.sportsapp.sportstrackingapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Entity
public class Comment {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "activity_id", insertable = false, updatable = false)
    private Activity activity;

    @NotBlank(message = "Comments can't be empty.")
    private String message;
}
