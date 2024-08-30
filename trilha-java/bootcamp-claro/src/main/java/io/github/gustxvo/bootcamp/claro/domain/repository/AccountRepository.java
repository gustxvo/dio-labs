package io.github.gustxvo.bootcamp.claro.domain.repository;

import io.github.gustxvo.bootcamp.claro.domain.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
