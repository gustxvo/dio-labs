package io.github.gustxvo.hexagonalarch.api.model;

import io.github.gustxvo.hexagonalarch.domain.model.Avenger;
import jakarta.validation.constraints.NotEmpty;

public record AvengerRequest(
        @NotEmpty
        String nick,

        @NotEmpty
        String person,

        String description,
        String history) {

    public Avenger toModel() {
        return new Avenger(null, nick, person, description, history);
    }

    public Avenger toModel(Long id) {
        return new Avenger(id, nick, person, description, history);
    }
}
