package com.tourneyofthereliquary.tourneyrestendpoint.models;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RedisHash
@JsonInclude(Include.NON_NULL)
public class Tournament {
    @Id
    @NonNull
    @EqualsAndHashCode.Include
    String id;

    @EqualsAndHashCode.Include
    @NonNull
    String name;
    
    @Reference
    @NonNull 
    SortedSet<Player> players; 
    
    @Reference
    @NonNull
    List<Set<Match>> matchHistory; 
    
    int roundNumber;

} 
