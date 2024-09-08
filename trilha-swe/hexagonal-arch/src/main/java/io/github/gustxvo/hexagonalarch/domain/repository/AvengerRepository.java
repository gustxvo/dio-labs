package io.github.gustxvo.hexagonalarch.domain.repository;

import io.github.gustxvo.hexagonalarch.domain.model.Avenger;

import java.util.List;
import java.util.Optional;

public interface AvengerRepository {

    List<Avenger> getAvengers();

    Optional<Avenger> findById(Long avengerId);

    boolean existsById(Long avengerId);

    Avenger save(Avenger avenger);

    void deleteById(Long avengerId);

    boolean nickAlreadyTaken(String nick);
}
