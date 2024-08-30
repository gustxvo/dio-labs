package io.github.gustxvo.bootcamp.claro.domain.repository;

import io.github.gustxvo.bootcamp.claro.domain.model.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

    boolean existsByCpf(String cpf);

}
