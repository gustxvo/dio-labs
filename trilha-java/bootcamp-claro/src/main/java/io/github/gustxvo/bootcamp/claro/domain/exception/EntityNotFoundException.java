package io.github.gustxvo.bootcamp.claro.domain.exception;

import java.io.Serial;

public class EntityNotFoundException extends DomainException {

    @Serial
    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(Object id) {
        super("Resource with id " + id + " not found.");
    }
}
