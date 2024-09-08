package io.github.gustxvo.hexagonalarch.domain.service;

import io.github.gustxvo.hexagonalarch.domain.exception.AvengerAlreadyExistsException;
import io.github.gustxvo.hexagonalarch.domain.exception.AvengerNotFoundException;
import io.github.gustxvo.hexagonalarch.domain.model.Avenger;
import io.github.gustxvo.hexagonalarch.domain.repository.AvengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvengerServiceImpl implements AvengerService {

    private final AvengerRepository avengerRepository;

    @Override
    public List<Avenger> getAvengers() {
        return avengerRepository.getAvengers();
    }

    @Override
    public Avenger findById(Long avengerId) {
        return avengerRepository.findById(avengerId).orElseThrow(() -> new AvengerNotFoundException(avengerId));
    }

    @Override
    public Avenger create(Avenger avenger) {
        if (avengerRepository.nickAlreadyTaken(avenger.nick())) {
            throw new AvengerAlreadyExistsException(avenger.nick());
        }
        return avengerRepository.save(avenger);
    }

    @Override
    public Avenger update(Avenger avenger) {
        if (!avengerRepository.existsById(avenger.id())) {
            throw new AvengerNotFoundException(avenger.id());
        }
        return avengerRepository.save(avenger);
    }

    @Override
    public void deleteById(Long avengerId) {
        if (!avengerRepository.existsById(avengerId)) {
            throw new AvengerNotFoundException(avengerId);
        }
        avengerRepository.deleteById(avengerId);
    }

}
