package net.ps.engine.condition;

import net.ps.engine.model.Order;

import java.util.Set;

public class UserTierConditionEvaluator implements ConditionEvaluator {

    private final Set<String> requiredTier;

    public UserTierConditionEvaluator(Set<String> requiredTier) {
        this.requiredTier = requiredTier;
    }

    @Override
    public boolean test(Order order) {
        return requiredTier.contains(order.userTier().getUserTierStr());
    }

    @Override
    public boolean evaluate(Order order) {
        return requiredTier.contains(order.userTier().getUserTierStr());
    }
}
