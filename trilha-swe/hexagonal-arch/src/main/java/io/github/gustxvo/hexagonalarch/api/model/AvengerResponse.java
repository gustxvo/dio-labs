package io.github.gustxvo.hexagonalarch.api.model;

import io.github.gustxvo.hexagonalarch.domain.model.Avenger;

public record AvengerResponse(Long id, String nick, String person, String description, String history) {

    public static AvengerResponse fromModel(Avenger avenger) {
        return new AvengerResponse(avenger.id(), avenger.nick(), avenger.person(),
                avenger.description(), avenger.history());
    }
}
