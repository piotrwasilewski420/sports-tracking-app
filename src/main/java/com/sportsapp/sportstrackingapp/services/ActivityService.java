package com.sportsapp.sportstrackingapp.services;

import com.sportsapp.sportstrackingapp.models.Activity;
import com.sportsapp.sportstrackingapp.repositories.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public void addActivity(Activity activity) {
        activityRepository.save(activity);
    }

    public Collection<Activity> getActivities() {
        return activityRepository.findAll();
    }
}
