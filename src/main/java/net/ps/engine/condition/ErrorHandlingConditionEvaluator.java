package net.ps.engine.condition;

import net.ps.engine.model.Order;

public class ErrorHandlingConditionEvaluator implements ConditionEvaluator {

    public ErrorHandlingConditionEvaluator() {

    }

    @Override
    public boolean test(Order order) {
        return true;
    }

    @Override
    public boolean evaluate(Order order) {
        return true;
    }
}
