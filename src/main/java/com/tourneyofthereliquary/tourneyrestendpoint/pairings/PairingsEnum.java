package com.tourneyofthereliquary.tourneyrestendpoint.pairings;

import lombok.Getter;

public enum PairingsEnum {
    
    SWISS(new SwissPairings());

    @Getter
    private Pairings pairingsMode;
    
    PairingsEnum(Pairings pairingsMode) {
        this.pairingsMode = pairingsMode;
    }

    
}
