package com.rg.microservice.accountservice.db.repository;

import com.rg.microservice.accountservice.db.entity.TempAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempAccountRepository extends JpaRepository<TempAccount, Long> {
}
