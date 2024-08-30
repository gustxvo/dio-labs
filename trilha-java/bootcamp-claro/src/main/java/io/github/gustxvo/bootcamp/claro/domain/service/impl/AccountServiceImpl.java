package io.github.gustxvo.bootcamp.claro.domain.service.impl;

import io.github.gustxvo.bootcamp.claro.domain.exception.EntityNotFoundException;
import io.github.gustxvo.bootcamp.claro.domain.model.account.Account;
import io.github.gustxvo.bootcamp.claro.domain.model.client.Client;
import io.github.gustxvo.bootcamp.claro.domain.repository.AccountRepository;
import io.github.gustxvo.bootcamp.claro.domain.service.AccountService;
import io.github.gustxvo.bootcamp.claro.domain.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final ClientService clientService;

    public AccountServiceImpl(AccountRepository accountRepository, ClientService clientService) {
        this.accountRepository = accountRepository;
        this.clientService = clientService;
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public Account createAccount(Account account) {
        UUID clientId = account.getClient().getId();
        Client client = clientService.findById(clientId);

        account.setClient(client);
        return accountRepository.save(account);
    }

}
