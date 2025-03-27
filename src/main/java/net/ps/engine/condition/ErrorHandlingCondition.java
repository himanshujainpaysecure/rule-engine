package net.ps.engine.condition;

import net.ps.engine.model.Order;

public class ErrorHandlingCondition implements Condition {

    public ErrorHandlingCondition() {

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
