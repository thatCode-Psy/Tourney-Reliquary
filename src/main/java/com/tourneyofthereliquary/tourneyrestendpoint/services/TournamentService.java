package com.tourneyofthereliquary.tourneyrestendpoint.services;



import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
//import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Service;

import com.tourneyofthereliquary.tourneyrestendpoint.models.Player;
import com.tourneyofthereliquary.tourneyrestendpoint.models.Round;
import com.tourneyofthereliquary.tourneyrestendpoint.models.Tournament;
import com.tourneyofthereliquary.tourneyrestendpoint.models.Match;
import com.tourneyofthereliquary.tourneyrestendpoint.repositories.ITournamentRepository;

import reactor.core.publisher.Mono;

@Service
public class TournamentService implements ITournamentService{


    @Autowired
    ITournamentRepository tournamentRepository;

    @Autowired
    ReactiveRedisOperations<String, Object> reactiveRedisOperations;

    @Override
    public Mono<Tournament> createNewTournament(String name) { 
        return tournamentRepository.save(new Tournament(UUID.randomUUID().toString(), name, new TreeSet<Player>(), new LinkedList<Round>()));
    }

    @Override
    public Mono<Tournament> updateTournament(String key, Tournament tournament) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTournament'");
    }

    @Override
    public Mono<Tournament> findTournamentByKey(String key) {
        return tournamentRepository.findByKey(key);
    }

    @Override
    public Mono<Tournament> generatePairingsForCurrentRound(String key) {
        return tournamentRepository.findByKey(key)
            .flatMap(tournament -> 
                {   
                    Round currentRound = tournament.getRounds().get(tournament.getRoundNumber());
                    currentRound.getMatches().addAll(currentRound.getPairingMode().getPairingsMode().generatePairings(tournament.getPlayers(), 0));
                    return tournamentRepository.save(tournament);
                });
    }
    
}
