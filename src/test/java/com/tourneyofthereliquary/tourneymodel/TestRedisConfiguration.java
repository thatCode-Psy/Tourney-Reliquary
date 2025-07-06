package com.tourneyofthereliquary.tourneymodel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.redis.lettucemod.RedisModulesClient;
import com.redis.testcontainers.RedisContainer;

@Import(TestContainersConfiguration.class)
@TestConfiguration
public class TestRedisConfiguration {
    
    @Autowired
    RedisContainer redis;

    @Bean
    public RedisModulesClient redisModulesClient(){
        return RedisModulesClient.create(redis.getRedisURI());
    }

}
