package io.github.gustxvo.bootcamp.claro.domain.service;

import io.github.gustxvo.bootcamp.claro.domain.model.client.Client;

import java.util.UUID;

public interface ClientService {

    Client findById(UUID uuid);

    Client register(Client client);
}
