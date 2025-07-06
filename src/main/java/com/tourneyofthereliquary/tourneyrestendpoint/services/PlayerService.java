package com.tourneyofthereliquary.tourneyrestendpoint.services;

import com.tourneyofthereliquary.tourneyrestendpoint.models.Player;

import reactor.core.publisher.Mono;

public class PlayerService implements IPlayerService {

    @Override
    public Mono<Player> createPlayerForTournament(String tournamentId, String name) {
        
        throw new UnsupportedOperationException("Unimplemented method 'createPlayerForTournament'");
    }

    @Override
    public Mono<Player> updatePlayerForTournament(String tournamentId, String playerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePlayerForTournament'");
    }

    @Override
    public Mono<Player> updatePlayerRecordFromMatch(String tournamentId, String playerId, String matchId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePlayerRecordFromMatch'");
    }
    
}
