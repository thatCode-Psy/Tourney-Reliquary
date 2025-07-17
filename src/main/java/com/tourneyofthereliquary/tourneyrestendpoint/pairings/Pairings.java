package com.tourneyofthereliquary.tourneyrestendpoint.pairings;

import java.util.Set;

import com.tourneyofthereliquary.tourneyrestendpoint.models.Match;
import com.tourneyofthereliquary.tourneyrestendpoint.models.Player;

public interface Pairings {
    
    public Set<Match> generatePairings(Set<Player> players, int startingTable);
}
