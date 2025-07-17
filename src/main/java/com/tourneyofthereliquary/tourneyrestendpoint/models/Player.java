package com.tourneyofthereliquary.tourneyrestendpoint.models;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.lang.NonNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RedisHash
public class Player implements Comparable<Player>{
    @Id
    @NonNull
    @EqualsAndHashCode.Include
    String id;

    @NonNull
    @EqualsAndHashCode.Include
    String name;  
    
    @NonNull
    PlayerRecord record;

    @Reference
    @NonNull
    Set<Player> previousOpponents;

    @Override
    public int compareTo(Player o) {
       return this.record.compareTo(o.record);
    }
}
