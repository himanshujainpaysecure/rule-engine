package net.ps.engine.rule;

import net.ps.engine.action.Action;
import net.ps.engine.condition.Condition;
import net.ps.engine.model.Order;

import java.util.List;

public class Rule {
    private final String name;
    private final int priority;
    private final List<Condition> conditions;
    private final List<Action> actions;
    private final boolean useAndLogic;

    public Rule(String name, int priority, List<Condition> conditions, List<Action> actions, boolean useAndLogic) {
        this.name = name;
        this.priority = priority;
        this.conditions = conditions;
        this.actions = actions;
        this.useAndLogic = useAndLogic;
    }

    /**
     * Evaluates the conditions based on the AND/OR logic flag.
     * @param order The order to be evaluated
     * @return boolean True if the rule passes based on the conditions
     */
    public boolean evaluate(Order order) {
        if (useAndLogic) {
            // Evaluate conditions using AND logic (all conditions must be true)
            return conditions.stream().allMatch(condition -> condition.test(order));
        } else {
            // Evaluate conditions using OR logic (at least one condition must be true)
            return conditions.stream().anyMatch(condition -> condition.test(order));
        }
    }

    /**
     * Executes all the actions associated with this rule.
     * @param order The order to apply actions on
     */
    public void executeActions(Order order) {
        actions.forEach(action -> action.execute(order));
    }

    public int getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    public boolean isUseAndLogic() {
        return useAndLogic;
    }
}

