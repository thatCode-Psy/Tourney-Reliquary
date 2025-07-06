package com.tourneyofthereliquary.tourneyrestendpoint.models;

import java.util.Set;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("round")
public record Round(int roundNumber, Set<Match> matches) {}
