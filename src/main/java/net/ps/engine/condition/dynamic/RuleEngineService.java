package net.ps.engine.condition.dynamic;

import java.util.List;
import java.util.Map;

public class RuleEngineService {

    private ConditionEval conditionEvaluator;

    // Set the condition evaluator (could be simple or complex)
    public void setConditionEvaluator(ConditionEval conditionEvaluator) {
        this.conditionEvaluator = conditionEvaluator;
    }

    public void evaluateRules(List<Rule> rules, Map<String, Object> inputData) {
        // Sort the rules based on priority using Streams
        rules.stream()
                .sorted((r1, r2) -> Integer.compare(r1.getPriority(), r2.getPriority()))  // Priority sorting
                .forEach(rule -> {
                    boolean ruleTriggered = rule.getConditions().stream()
                            .allMatch(condition -> conditionEvaluator.evaluate(condition, inputData)); // Check all conditions

                    if (ruleTriggered) {
                        performActions(rule.getActions()); // Perform actions if rule is triggered
                    }
                });
    }

    private void performActions(List<String> actions) {
        actions.forEach(action -> {
            System.out.println("Action triggered: " + action);
            // Perform the action, e.g., block card, send email, etc.
        });
    }
}
