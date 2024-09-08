package io.github.gustxvo.hexagonalarch.domain.service;

import io.github.gustxvo.hexagonalarch.domain.model.Avenger;

import java.util.List;

public interface AvengerService {

    List<Avenger> getAvengers();

    Avenger findById(Long id);

    Avenger create(Avenger avenger);

    void deleteById(Long avengerId);

    Avenger update(Avenger model);
}
