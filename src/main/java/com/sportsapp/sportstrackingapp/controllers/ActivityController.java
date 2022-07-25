package com.sportsapp.sportstrackingapp.controllers;

import com.sportsapp.sportstrackingapp.models.Activity;
import com.sportsapp.sportstrackingapp.services.ActivityService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping("/activities")
    public ResponseEntity<Object> addActivity(@Valid @RequestBody Activity activity) {
        activityService.addActivity(activity);
        return ResponseEntity.ok("Activity added.");
    }

    @GetMapping("/activities")
    public Collection<Activity> retrieveAllActivities() {
        return activityService.getActivities();
    }
}
