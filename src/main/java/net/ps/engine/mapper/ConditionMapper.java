package net.ps.engine.mapper;

import net.ps.engine.condition.ConditionType;

import java.util.Set;

public class ConditionMapper {
    private ConditionType type; // Type of the condition (e.g., "PriceRangeCondition", "CountryCondition", etc.)
    private Set<String> values; // For conditions like "CountryCondition", it can hold allowed country names
    private Double min; // For conditions like "PriceRangeCondition", it can hold the minimum price
    private Double max; // For conditions like "PriceRangeCondition", it can hold the maximum price
    private String value; // For conditions like "UserTierCondition", it holds the user tier value

    // Getters and Setters
    public ConditionType getType() {
        return type;
    }

    public void setType(ConditionType type) {
        this.type = type;
    }

    public Set<String> getValues() {
        return values;
    }

    public void setValues(Set<String> values) {
        this.values = values;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
