package com.sportsapp.sportstrackingapp.repositories;

import com.sportsapp.sportstrackingapp.models.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {

}