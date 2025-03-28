package net.ps.engine.condition.dynamic;


import java.util.List;

public class Rule {

    private String ruleName;
    private int priority;
    private List<Condition> conditions;
    private List<String> actions;

    // Constructor, Getters and Setters
    public Rule(String ruleName, int priority, List<Condition> conditions, List<String> actions) {
        this.ruleName = ruleName;
        this.priority = priority;
        this.conditions = conditions;
        this.actions = actions;
    }

    public String getRuleName() {
        return ruleName;
    }

    public int getPriority() {
        return priority;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }
}

