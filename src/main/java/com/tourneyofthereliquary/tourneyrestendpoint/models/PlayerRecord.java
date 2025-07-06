package com.tourneyofthereliquary.tourneyrestendpoint.models;

import lombok.Data;

@Data
public abstract class PlayerRecord implements Comparable<PlayerRecord> {
    
    public abstract Integer getMatchScore();

    public abstract Integer compareTieBreakersTo(PlayerRecord other);

    @Override
    public int compareTo(PlayerRecord other) {
        if(this.getClass() != other.getClass()) {
            throw new IllegalArgumentException(String.format("Cannot compare PlayerRecords of type {1} and type {2}", this.getClass().getName(), other.getClass().getName()));
        }
        if(this.getMatchScore() == other.getMatchScore()){
            return this.compareTieBreakersTo(other);
        }
        return this.getMatchScore().compareTo(other.getMatchScore());
    }
}
