package net.ps.engine.mapper;

import java.util.List;

/**
 * Represents a container for storing a list of {@link RuleMapper} objects.
 * This class provides a structure to map JSON data to Object
 */
public class RulesContainer {
    private List<RuleMapper> rules;

    public List<RuleMapper> getRules() {
        return rules;
    }

    public void setRules(List<RuleMapper> rules) {
        this.rules = rules;
    }
}

