package com.tourneyofthereliquary.tourneyrestendpoint.services;

import com.tourneyofthereliquary.tourneyrestendpoint.models.Tournament;

import reactor.core.publisher.Mono;


public interface ITournamentService {
        Mono<Tournament> createNewTournament(String name);

        Mono<Tournament> updateTournament(String key, Tournament tournament);

        Mono<Tournament> findTournamentByKey(String key);
}
