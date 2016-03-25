package com.thoughtworks.continuinglearning.functionaltictactoe;

import java.util.List;
import java.util.Optional;

public class Game {
    private final List<EndCondition> endConditions;

    public Game(List<EndCondition> endConditions) {
        this.endConditions = endConditions;
    }

    public Optional<EndCondition> endCondition() {
        return endConditions.
                stream().
                filter(endCondition -> endCondition.isMet()).
                findFirst();
    }
}
