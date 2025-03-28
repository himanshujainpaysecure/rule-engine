package net.ps.engine.condition;

import net.ps.engine.model.Order;

public class TotalDepositConditionEvaluator implements ConditionEvaluator {

    private final double minPrice;
    private final double maxPrice;

    public TotalDepositConditionEvaluator(double minPrice, double maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean test(Order order) {
        return order.totalDeposit() >= minPrice && order.totalDeposit() <= maxPrice;
    }

    @Override
    public boolean evaluate(Order order) {
        return order.totalDeposit() >= minPrice && order.totalDeposit() <= maxPrice;
    }
}

