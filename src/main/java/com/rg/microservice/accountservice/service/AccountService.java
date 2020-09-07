package com.rg.microservice.accountservice.service;

import com.rg.microservice.accountservice.db.entity.Account;
import com.rg.microservice.accountservice.db.entity.TempAccount;
import com.rg.microservice.accountservice.db.repository.AccountRepository;
import com.rg.microservice.accountservice.db.repository.TempAccountRepository;
import com.rg.microservice.accountservice.dto.RegisterCheckDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final TempAccountRepository tempAccountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, TempAccountRepository tempAccountRepository) {
        this.accountRepository = accountRepository;
        this.tempAccountRepository = tempAccountRepository;
    }

    public ResponseEntity<?> registerCheck(RegisterCheckDto registerCheckDto) {
        // check data in postgres
        Account accountByEmail = accountRepository.getFirstByEmail(registerCheckDto.getEmail());
        if (accountByEmail != null) return ResponseEntity.status(HttpStatus.CONFLICT).build();

        // check redis
        TempAccount tempAccountByEmail = tempAccountRepository.getFirstByEmail(registerCheckDto.getEmail());
        if (tempAccountByEmail != null) return ResponseEntity.ok().build();

        // save to temp of redis
        tempAccountByEmail = new TempAccount();
        tempAccountByEmail.setEmail(registerCheckDto.getEmail());
        tempAccountByEmail.setValid(false);
        tempAccountRepository.save(tempAccountByEmail);

        return ResponseEntity.ok().build();
    }
}
