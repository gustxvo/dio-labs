package io.github.gustxvo.hexagonalarch.api.exception;

import io.github.gustxvo.hexagonalarch.domain.exception.AvengerAlreadyExistsException;
import io.github.gustxvo.hexagonalarch.domain.exception.AvengerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AvengerNotFoundException.class)
    public ProblemDetail handleAvengerNotFoundException(AvengerNotFoundException exception) {
        ProblemDetail problemDetails = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
        problemDetails.setType(URI.create("/errors/avenger-not-found"));
        problemDetails.setTitle("Avenger Not Found");
        problemDetails.setDetail(exception.getMessage());
        problemDetails.setProperty("avenger_id", exception.getId());
        return problemDetails;
    }

    @ExceptionHandler(AvengerAlreadyExistsException.class)
    public ProblemDetail handleAvengerNotFoundException(AvengerAlreadyExistsException exception) {
        ProblemDetail problemDetails = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, exception.getMessage());
        problemDetails.setType(URI.create("/errors/resource-already-exists"));
        problemDetails.setTitle("Resource already exists");
        problemDetails.setDetail(exception.getMessage());
        return problemDetails;
    }

}
