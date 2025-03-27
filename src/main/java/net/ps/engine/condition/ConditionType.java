package net.ps.engine.condition;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ConditionType {
    COUNTRY_CONDITION("CountryCondition"),
    PRICE_RANGE_CONDITION("PriceRangeCondition"),
    TOTAL_DEPOSIT_CONDITION("TotalDepositCondition"),
    PAYMENT_METHOD_CONDITION("PaymentMethodCondition"),
    TXN_STATUS_CONDITION("TxnStatusCondition"),
    TXN_AMT_CONDITION("TxnAmountCondition"),
    PRESET_DEPOSIT_AMT_CONDITION("PresetDepositAmtCondition"),
    USER_TIER_CONDITION("UserTierCondition"),
    ERROR_HANDLING_CONDITION("ErrorHandlingCondition");

    private final String conditionString;

    ConditionType(String conditionString) {
        this.conditionString = conditionString;
    }

    public String getConditionString() {
        return conditionString;
    }

    @JsonCreator
    public static ConditionType fromString(String type) {
        for (ConditionType conditionType : ConditionType.values()) {
            if (conditionType.getConditionString().equalsIgnoreCase(type)) {
                return conditionType;
            }
        }
        throw new IllegalArgumentException("Unknown condition type: " + type);
    }

    @JsonValue
    public String toValue() {
        return conditionString;
    }
}


