package com.sportsapp.sportstrackingapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.util.List;

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

    @Range(min = 13, max = 130, message = "Age must be between 13 and 130")
    private Integer age;

    private String sex;

    private Double weight;

    private Double height;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "MEMBERSHIP",
            joinColumns = @JoinColumn(name = "ATHLETE_ID"),
            inverseJoinColumns = @JoinColumn(name = "CLUB_ID")
    )
    private List<Club> clubs;

    public void addClub(Club club) {
        clubs.add(club);
    }
}