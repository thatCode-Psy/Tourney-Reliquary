package com.tourneyofthereliquary.tourneyrestendpoint.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.lang.NonNull;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@RedisHash
public class Match {
    @Id
    @EqualsAndHashCode.Include
    String id;

    @NonNull
    @Reference
    Player player1; 
    
    //Can be null in case of bye
    @Reference
    Player player2; 
    
    @EqualsAndHashCode.Include
    int tableNum; 
    
    int player1Wins; 
    
    int player2Wins;
}
