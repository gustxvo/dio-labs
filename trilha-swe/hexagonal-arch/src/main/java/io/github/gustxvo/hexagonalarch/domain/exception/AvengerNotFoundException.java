package io.github.gustxvo.hexagonalarch.domain.exception;

import lombok.Getter;

@Getter
public class AvengerNotFoundException extends RuntimeException {

    private final Long id;

    public AvengerNotFoundException(Long id) {
        super("Avenger with id " + id + " not found!");
        this.id = id;
    }

}
