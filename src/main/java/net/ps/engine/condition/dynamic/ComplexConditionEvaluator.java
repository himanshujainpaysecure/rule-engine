package net.ps.engine.condition.dynamic;

import java.util.Map;
import java.util.stream.Stream;

public class ComplexConditionEvaluator implements ConditionEval {

    @Override
    public boolean evaluate(Condition condition, Map<String, Object> inputData) {
        // If it's a simple condition, delegate to the SimpleConditionEvaluator
        if (condition.getLogicalOperator() == null) {
            return new SimpleConditionEvaluator().evaluate(condition, inputData);
        }

        // Handle complex conditions with logical operators (AND, OR, NOT)
        switch (condition.getLogicalOperator()) {
            case "AND":
                return Stream.of(condition.getLeft(), condition.getRight())
                        .allMatch(c -> new SimpleConditionEvaluator().evaluate(c, inputData));
            case "OR":
                return Stream.of(condition.getLeft(), condition.getRight())
                        .anyMatch(c -> new SimpleConditionEvaluator().evaluate(c, inputData));
            case "NOT":
                return !new SimpleConditionEvaluator().evaluate(condition.getLeft(), inputData);
            default:
                throw new UnsupportedOperationException("Unknown logical operator: " + condition.getLogicalOperator());
        }
    }
}
