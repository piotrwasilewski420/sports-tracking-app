package com.sportsapp.sportstrackingapp.repositories;

import com.sportsapp.sportstrackingapp.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
