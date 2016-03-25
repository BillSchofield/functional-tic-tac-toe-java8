package com.thoughtworks.continuinglearning.functionaltictactoe;

import java.util.List;
import java.util.Optional;

public class ThreeInARowWinsEndCondition implements EndCondition{
    private final List<Condition> conditions;
    private Optional<Condition> firstMet;

    public ThreeInARowWinsEndCondition(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean isMet() {
        firstMet = conditions.
                stream().
                filter(condition -> condition.isMet()).
                findFirst();
        return firstMet.isPresent();
    }

    @Override
    public String description() {
        return "";
    }
}
