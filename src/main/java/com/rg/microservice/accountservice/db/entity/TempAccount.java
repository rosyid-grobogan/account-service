package com.rg.microservice.accountservice.db.entity;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Data
@RedisHash(value = "account", timeToLive = 3600)
public class TempAccount {
    
    @Id
    private String id;
    private String email;
    private boolean valid = false;
}
