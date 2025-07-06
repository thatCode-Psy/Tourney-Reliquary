package com.tourneyofthereliquary.tourneymodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tourneyofthereliquary.tourneyrestendpoint.RestEndpointApplication;

@SpringBootApplication
public class TestRestEndpointApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestEndpointApplication.class, args);
    }
}