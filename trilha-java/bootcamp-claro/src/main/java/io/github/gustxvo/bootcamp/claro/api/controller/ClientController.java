package io.github.gustxvo.bootcamp.claro.api.controller;

import io.github.gustxvo.bootcamp.claro.domain.model.client.Client;
import io.github.gustxvo.bootcamp.claro.domain.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService registrationService;

    public ClientController(ClientService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable String id) {
        Client client = registrationService.findById(UUID.fromString(id));
        return ResponseEntity.ok(client);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Client> register(@RequestBody Client client) {
        return ResponseEntity.ok(registrationService.register(client));
    }
}
