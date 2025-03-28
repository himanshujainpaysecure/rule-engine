package net.ps.engine.condition.dynamic;

import java.util.Map;

public class SimpleConditionEvaluator implements ConditionEval {

    @Override
    public boolean evaluate(Condition condition, Map<String, Object> inputData) {
        Object paramValue = inputData.get(condition.getParameter());
        if (paramValue == null) {
            return false;
        }

        return switch (condition.getOperator()) {
            case "equals" -> paramValue.equals(condition.getValue());
            case "greaterThan" ->
                    (paramValue instanceof Number)
                            && ((Number) paramValue).doubleValue() > ((Number) condition.getValue()).doubleValue();
            case "lessThan" ->
                    (paramValue instanceof Number)
                            && ((Number) paramValue).doubleValue() < ((Number) condition.getValue()).doubleValue();
            default -> false;
        };
    }
}

