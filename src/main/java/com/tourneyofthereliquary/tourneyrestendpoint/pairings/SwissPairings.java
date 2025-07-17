package com.tourneyofthereliquary.tourneyrestendpoint.pairings;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


import com.tourneyofthereliquary.tourneyrestendpoint.models.Match;
import com.tourneyofthereliquary.tourneyrestendpoint.models.Player;

public class SwissPairings implements Pairings{

    @Override
    public Set<Match> generatePairings(Set<Player> players, int startingTable) {
        if(players == null) {
            throw new NullPointerException("Set of players cannot be null for generating players");
        }
        HashSet<Match> matches = new HashSet<>();
        LinkedList<Player> swissShufflePlayers = getSwissShufflePlayers(players);
        int tableNum = startingTable;
        
        while(swissShufflePlayers.size() > 0) {
            Player player1 = swissShufflePlayers.removeFirst();
            Player player2 = null;

            for (int i = 0; i < swissShufflePlayers.size(); ++i) {
                if(!swissShufflePlayers.get(i).getPreviousOpponents().contains(player1)) {
                    player2 = swissShufflePlayers.remove(i);
                    break;
                }
            }            
            matches.add(Match.builder().player1(player1).player2(player2).tableNum(tableNum++).build());
        }
        
        return matches;
    }

    private LinkedList<Player> getSwissShufflePlayers(Set<Player> players) {
        if (players == null || players.isEmpty()) {
            return new LinkedList<>();
        }
        LinkedList<Player> sortedShuffledList = new LinkedList<Player>(players); 
        Collections.shuffle(sortedShuffledList);
        Collections.sort(sortedShuffledList, playerComparator());

        return sortedShuffledList;
    }

    private static Comparator<Player> playerComparator() {
        return new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getRecord().getMatchScore().compareTo(o2.getRecord().getMatchScore());
            }
        };
    }
    
    
}
