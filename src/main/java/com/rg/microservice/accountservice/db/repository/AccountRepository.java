package com.rg.microservice.accountservice.db.repository;

import com.rg.microservice.accountservice.db.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account getFirstByEmail(String email);
}
