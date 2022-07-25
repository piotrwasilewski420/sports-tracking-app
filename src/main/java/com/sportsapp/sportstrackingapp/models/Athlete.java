package com.sportsapp.sportstrackingapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter @Setter @Entity @RequiredArgsConstructor
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Login is mandatory.")
    private String login;

    @NotBlank(message = "Password is mandatory.")
    private String password;

    @Pattern(regexp = "\\D+", message = "No digits allowed.")
    private String firstName;

    @Pattern(regexp = "\\D+", message = "No digits allowed.")
    private String lastName;

    @NotNull(message = "Email is mandatory")
    @Email(message = "Incorrect email format.")
    private String email;

    @Min(value = 13, message = "Must be older than 13.")
    @Max(value = 130, message = "Value of age field must be less than 130.")
    private Integer age;

    private String sex;

    private Double weight;

    private Double height;

    @OneToMany
    @JoinColumn(name = "athlete_id")
    private Collection<Activity> activities;

    @ManyToMany
    private Collection<Club> clubs;
}