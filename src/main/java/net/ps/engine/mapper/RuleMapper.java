package net.ps.engine.mapper;

import java.util.List;

public class RuleMapper {
    private String name; // Rule name
    private int priority; // Priority of the rule
    private List<ConditionMapper> conditions; // List of conditions for this rule
    private List<ActionMapper> actions; // List of actions to take if the conditions are met
    private boolean useAndLogic; //determines whether the conditions should be evaluated using AND or OR logic.

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public List<ConditionMapper> getConditions() {
        return conditions;
    }

    public void setConditions(List<ConditionMapper> conditions) {
        this.conditions = conditions;
    }

    public List<ActionMapper> getActions() {
        return actions;
    }

    public void setActions(List<ActionMapper> actions) {
        this.actions = actions;
    }

    public boolean isUseAndLogic() {
        return useAndLogic;
    }

    public void setUseAndLogic(boolean useAndLogic) {
        this.useAndLogic = useAndLogic;
    }
}

