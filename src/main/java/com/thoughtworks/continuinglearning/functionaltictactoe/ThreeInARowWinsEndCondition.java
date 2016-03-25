package com.thoughtworks.continuinglearning.functionaltictactoe;

import java.util.List;

public class ThreeInARowWinsEndCondition implements EndCondition{
    private final List<Condition> conditions;

    public ThreeInARowWinsEndCondition(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean isMet() {
        return conditions.
                stream().
                filter(condition -> condition.isMet()).
                findFirst().isPresent();
    }

    @Override
    public String description() {
        return "A Player won!";
    }
}
