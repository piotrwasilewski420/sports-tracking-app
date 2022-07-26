package com.sportsapp.sportstrackingapp.exceptions;

import java.util.logging.Logger;

public class ClubNotFoundException extends RuntimeException {
    public ClubNotFoundException(Long id) {
        final Logger logger = Logger.getLogger(ClubNotFoundException.class.getName());
        logger.warning("Club " + id + " not found.");
    }
}
