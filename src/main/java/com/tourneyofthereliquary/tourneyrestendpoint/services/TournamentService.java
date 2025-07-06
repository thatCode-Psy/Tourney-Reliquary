package com.tourneyofthereliquary.tourneyrestendpoint.services;



import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
//import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Service;

import com.tourneyofthereliquary.tourneyrestendpoint.models.Player;
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
        return tournamentRepository.save(new Tournament(UUID.randomUUID().toString(), name, new TreeSet<Player>(), new LinkedList<Set<Match>>()));
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
    public Mono<Tournament> generatePairings(String key) {
        return tournamentRepository.findByKey(key)
            .flatMap(tournament -> 
                {   
                    tournament.getMatchHistory().add(swissPairPlayers(tournament.getPlayers()));
                    return tournamentRepository.save(tournament);
                });
    }

    private Set<Match> swissPairPlayers(SortedSet<Player> players){
        HashSet<Match> matches = new HashSet<>();

        
        return matches;
    }
    
}
