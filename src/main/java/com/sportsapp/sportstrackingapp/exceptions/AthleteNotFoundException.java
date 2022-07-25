package com.sportsapp.sportstrackingapp.exceptions;

import java.util.logging.Logger;

public class AthleteNotFoundException extends Throwable {
    public AthleteNotFoundException(Long id) {
        final Logger logger = Logger.getLogger(AthleteNotFoundException.class.getName());
        logger.warning("Athlete " + id + " not found.");
    }
}
