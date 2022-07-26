package com.sportsapp.sportstrackingapp.exceptionHandlers;

import com.sportsapp.sportstrackingapp.exceptions.AthleteNotFoundException;
import com.sportsapp.sportstrackingapp.exceptions.ClubNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { IllegalArgumentException.class})
    protected ResponseEntity<Object> handleIllegalArgument(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Illegal argument.";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = { IllegalStateException.class })
    protected ResponseEntity<Object> handleIllegalState(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Illegal state.";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = { AthleteNotFoundException.class })
    protected ResponseEntity<Object> handleAthleteNotFoundException(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Athlete not found.";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = { ClubNotFoundException.class })
    protected ResponseEntity<Object> handleClubNotFoundException(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Club not found.";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
