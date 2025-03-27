package net.ps.engine.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserTier {
    BRONZE("Bronze"),
    SILVER("Silver"),
    GOLD("Gold"),
    PLATINUM("Platinum"),
    VIP("VIP");

    private final String userTierStr;

    UserTier(String userTierStr) {
        this.userTierStr = userTierStr;
    }

    public String getUserTierStr() {
        return userTierStr;
    }

    @JsonCreator
    public static UserTier fromString(String userTierStr) {
        for (UserTier userTierString : UserTier.values()) {
            if (userTierString.getUserTierStr().equalsIgnoreCase(userTierStr)) {
                return userTierString;
            }
        }
        throw new IllegalArgumentException("Unknown condition type: " + userTierStr);
    }

    @JsonValue
    public String toValue() {
        return userTierStr;
    }
}
