package net.ps.engine.condition;

import net.ps.engine.model.Order;

import java.util.Set;

public class CountryCondition implements Condition {

    private final Set<String> allowedCountries;

    public CountryCondition(Set<String> allowedCountries) {
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



