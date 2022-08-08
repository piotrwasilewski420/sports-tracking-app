package com.sportsapp.sportstrackingapp.exceptions;

import java.util.logging.Logger;

public class ActivityNotFoundException extends RuntimeException {
    public ActivityNotFoundException(Long activityId) {
        final Logger logger = Logger.getLogger(ActivityNotFoundException.class.getName());
        logger.warning("Activity " + activityId + " not found.");
    }
}
