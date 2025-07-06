package com.tourneyofthereliquary.tourneyrestendpoint.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.tourneyofthereliquary.tourneyrestendpoint.models.Player;
import com.tourneyofthereliquary.tourneyrestendpoint.models.Round;
import com.tourneyofthereliquary.tourneyrestendpoint.models.Tournament;
import com.tourneyofthereliquary.tourneyrestendpoint.repositories.TournamentRepository;
import com.tourneyofthereliquary.tourneyrestendpoint.services.ITournamentService;

import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.support.collections.RedisZSet;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/tournaments")
public class TournamentController {
    
    @Autowired
    TournamentRepository tournamentRepository;

    @Autowired
    ITournamentService tournamentService; 

    // @PostMapping()
    // public Mono<Tournament> createNewTournament() {
    //     return tournamentRepository.save(Tournament.of(RedisZSet.create(null, null), new ConcurrentLinkedDeque<Round>(), 0));
    // }

    // @PostMapping("/{id}/players")
    // public Mono<Player> addPlayer(@PathVariable String tournamentId, @RequestBody String name) {
    //     //TODO: process POST request
    //     Mono<Tournament> tournamentMono = tournamentRepository.findById(tournamentId);
    //     tournamentMono.subscribe(tournament -> {
    //         tournament
    //     });
    //     return entity;
    // }
    
    
    
}
