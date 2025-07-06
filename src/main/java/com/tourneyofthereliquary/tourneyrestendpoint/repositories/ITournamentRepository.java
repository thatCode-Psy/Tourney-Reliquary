package com.tourneyofthereliquary.tourneyrestendpoint.repositories;

import com.tourneyofthereliquary.tourneyrestendpoint.models.Player;
import com.tourneyofthereliquary.tourneyrestendpoint.models.Tournament;

import reactor.core.publisher.Mono;

public interface ITournamentRepository {

    Mono<Tournament> save(Tournament tournament);
    
    Mono<Tournament> findByKey(String key);

    Mono<Long> addPlayerToTournament(String tournamentKey, Player player);
}
