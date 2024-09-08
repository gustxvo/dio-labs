package io.github.gustxvo.hexagonalarch.domain.exception;

import lombok.Getter;

@Getter
public class AvengerAlreadyExistsException extends RuntimeException {

    private final String nick;

    public AvengerAlreadyExistsException(String nick) {
        super("Avenger with nick '" + nick + "' already exists!");
        this.nick = nick;
    }

}
