package com.rg.microservice.accountservice.controller;

import com.rg.microservice.accountservice.dto.RegisterCheckDto;
import com.rg.microservice.accountservice.service.AccountService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class AccountController {
    // call service
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/check")
    public ResponseEntity<?> registerCheck(@RequestBody RegisterCheckDto registerCheckDto) {
        log.debug("register {}", registerCheckDto);
        return accountService.registerCheck(registerCheckDto);
    }

    @GetMapping("/load")
    public String testLoadBalancer() {
        return accountService.testLoadBalancer();
    }
}
