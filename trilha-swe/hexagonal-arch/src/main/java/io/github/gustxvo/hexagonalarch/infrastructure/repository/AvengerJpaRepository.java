package io.github.gustxvo.hexagonalarch.infrastructure.repository;

import io.github.gustxvo.hexagonalarch.infrastructure.model.AvengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvengerJpaRepository extends JpaRepository<AvengerEntity, Long> {

    boolean existsByNick(String nick);

}
