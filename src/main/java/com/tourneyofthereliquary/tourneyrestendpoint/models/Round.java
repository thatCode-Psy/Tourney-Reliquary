package com.tourneyofthereliquary.tourneyrestendpoint.models;

import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.lang.NonNull;

import com.tourneyofthereliquary.tourneyrestendpoint.pairings.PairingsEnum;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@RedisHash("round")
public class Round {
    @Id
    @NonNull
    @EqualsAndHashCode.Include
    String id;

    @NonNull
    String roundName;

    @NonNull
    PairingsEnum pairingMode;

    @NonNull
    List<Match> matches;
}
