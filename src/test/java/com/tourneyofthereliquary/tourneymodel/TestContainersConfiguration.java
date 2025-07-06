package com.tourneyofthereliquary.tourneymodel;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.redis.testcontainers.RedisContainer;


@TestConfiguration
public class TestContainersConfiguration {
    @Bean
    RedisContainer redisContainer() {
        return new RedisContainer("redis:latest");
    }
}
