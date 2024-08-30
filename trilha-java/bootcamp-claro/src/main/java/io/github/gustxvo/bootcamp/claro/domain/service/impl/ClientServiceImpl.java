package io.github.gustxvo.bootcamp.claro.domain.service.impl;

import io.github.gustxvo.bootcamp.claro.domain.exception.DomainException;
import io.github.gustxvo.bootcamp.claro.domain.exception.EntityNotFoundException;
import io.github.gustxvo.bootcamp.claro.domain.model.client.Client;
import io.github.gustxvo.bootcamp.claro.domain.repository.ClientRepository;
import io.github.gustxvo.bootcamp.claro.domain.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client findById(UUID id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public Client register(Client client) {
        if (clientRepository.existsByCpf(client.getCpf())) {
            throw new DomainException("Client with cpf " + client.getCpf() + " already exists");
        }
        return clientRepository.save(client);
    }
}
