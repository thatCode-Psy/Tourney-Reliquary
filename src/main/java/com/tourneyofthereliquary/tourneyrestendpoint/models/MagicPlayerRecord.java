package com.tourneyofthereliquary.tourneyrestendpoint.models;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MagicPlayerRecord extends PlayerRecord {
    int matchPoints;
    float opponentMatchWinPercentage; 
    float gameWinPercentage; 
    float opponentGameWinPercentage; 

    
    @Override
    public Integer getMatchScore() {
        return this.getMatchScore();
    }

    @Override
    public Integer compareTieBreakersTo(PlayerRecord other) {
        if(!(other instanceof MagicPlayerRecord)) {
            throw new IllegalArgumentException(String.format("Cannot compare records of type {0} and {1}", MagicPlayerRecord.class.getName(), other.getClass().getName()));
        }
        MagicPlayerRecord o = (MagicPlayerRecord)other;
        float epsilon = 0.001f;
        float gameWinDifference = this.gameWinPercentage - o.gameWinPercentage;
        if(Math.abs(gameWinDifference) > epsilon) {
            if(gameWinDifference > 0f) {
                return 1;
            }
            return -1;
        }
        float opponentMatchWinDifference = this.opponentGameWinPercentage - o.opponentGameWinPercentage;
        if(Math.abs(opponentMatchWinDifference) > epsilon) {
            if(opponentMatchWinDifference > 0f) {
                return 1;
            }
            return -1;
        }
        return 0;
    }
}
