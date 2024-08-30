package io.github.gustxvo.bootcamp.claro.domain.service;

import io.github.gustxvo.bootcamp.claro.domain.model.account.Account;

public interface AccountService {

    Account createAccount(Account account);

    Account findById(Long id);
}
