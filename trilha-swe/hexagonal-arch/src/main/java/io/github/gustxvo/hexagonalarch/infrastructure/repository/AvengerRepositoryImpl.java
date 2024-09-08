package io.github.gustxvo.hexagonalarch.infrastructure.repository;

import io.github.gustxvo.hexagonalarch.domain.model.Avenger;
import io.github.gustxvo.hexagonalarch.domain.repository.AvengerRepository;
import io.github.gustxvo.hexagonalarch.infrastructure.model.AvengerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AvengerRepositoryImpl implements AvengerRepository {

    private final AvengerJpaRepository jpaRepository;

    @Override
    public List<Avenger> getAvengers() {
        return jpaRepository.findAll().stream()
                .map(AvengerEntity::toModel)
                .toList();
    }

    @Override
    public Optional<Avenger> findById(Long avengerId) {
        return jpaRepository.findById(avengerId)
                .map(AvengerEntity::toModel);
    }

    @Override
    public boolean existsById(Long avengerId) {
        return jpaRepository.existsById(avengerId);
    }

    @Override
    public Avenger save(Avenger avenger) {
        AvengerEntity avengerEntity = new AvengerEntity(avenger);
        return jpaRepository.save(avengerEntity).toModel();
    }

    @Override
    public void deleteById(Long avengerId) {
        jpaRepository.deleteById(avengerId);
    }

}
