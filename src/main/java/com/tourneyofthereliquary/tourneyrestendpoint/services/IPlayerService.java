package com.tourneyofthereliquary.tourneyrestendpoint.services;

import com.tourneyofthereliquary.tourneyrestendpoint.models.Player;

import reactor.core.publisher.Mono;

public interface IPlayerService {
    
    public Mono<Player> createPlayerForTournament(String tournamentId, String name);

    public Mono<Player> updatePlayerForTournament(String tournamentId, String playerId);

    public Mono<Player> updatePlayerRecordFromMatch(String tournamentId, String playerId, String matchId);

}
