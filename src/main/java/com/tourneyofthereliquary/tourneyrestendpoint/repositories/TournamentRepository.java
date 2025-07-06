package com.tourneyofthereliquary.tourneyrestendpoint.repositories;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.redis.lettucemod.api.StatefulRedisModulesConnection;
import com.tourneyofthereliquary.tourneyrestendpoint.models.Player;
import com.tourneyofthereliquary.tourneyrestendpoint.models.Tournament;

import io.lettuce.core.json.DefaultJsonParser;
import io.lettuce.core.json.JsonParser;
import io.lettuce.core.json.JsonPath;
import io.lettuce.core.json.JsonValue;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class TournamentRepository implements ITournamentRepository{

    @Autowired
    private StatefulRedisModulesConnection<String, String> connection;

    private JsonParser jsonParser;

    public TournamentRepository(){
        jsonParser = new DefaultJsonParser();
    }

    
    @Override
    public Mono<Tournament> save(Tournament tournament) {
        if(tournament.getId() == null) {
            tournament.setId(UUID.randomUUID().toString());
        }
        
        return connection.reactive().jsonSet(tournament.getId(), JsonPath.of("$"), jsonParser.fromObject(tournament)).map(_ -> tournament);
        
    }

    @Override
    public Mono<Tournament> findByKey(String key) {
        return connection.reactive().jsonGet(key, JsonPath.of("$"))
                                    .map(json -> json.asJsonArray()
                                                    .get(0)
                                                    .toObject(Tournament.class))
                                    .next();
        
    }

    @Override
    public Mono<Long> addPlayerToTournament(String tournamentKey, Player player) {
        return connection.reactive().jsonArrappend(tournamentKey, JsonPath.of("$.players"), jsonParser.fromObject(player)).next();
    }

    
    
}
