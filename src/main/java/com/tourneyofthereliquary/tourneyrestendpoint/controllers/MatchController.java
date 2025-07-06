package com.tourneyofthereliquary.tourneyrestendpoint.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.tourneyofthereliquary.tourneyrestendpoint.models.Match;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MatchController {
    
    @GetMapping("/currentMatch")
    public Match getCurrentPlayerMatch(@RequestParam String param) {
        throw new UnsupportedOperationException("Not implemented");
    }
    
}
