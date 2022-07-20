package com.example.sportstrackingapp.repositories;

import com.example.sportstrackingapp.entities.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {

}