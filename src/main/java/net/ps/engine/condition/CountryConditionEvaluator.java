package net.ps.engine.condition;

import net.ps.engine.model.Order;

import java.util.Set;

public class CountryConditionEvaluator implements ConditionEvaluator {

    private final Set<String> allowedCountries;

    public CountryConditionEvaluator(Set<String> allowedCountries) {
        this.allowedCountries = allowedCountries;
    }

    @Override
    public boolean test(Order order) {
        return allowedCountries.contains(order.country());
    }

    @Override
    public boolean evaluate(Order order) {
        return allowedCountries.contains(order.country());
    }
}



