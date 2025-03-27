package net.ps.engine.action;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ActionType {
    SHOW_PAYMENT_METHOD_ACTION("ShowPaymentMethodAction"),
    DISPLAY_MESSAGE_ACTION("DisplayMessageAction"),
    SHOW_PROMOTION_ACTION("ShowPromotionAction"),
    BLOCK_CARD("BlockCardAction"),
    SEND_EMAIL("SendEmailAction"),
    BLOCK_FUTURE_TXN_ACTION("BlockFutureTxnAction"),
    APPLY_DISCOUNT("ApplyDiscountAction");

    private final String actionString;

    ActionType(String actionString) {
        this.actionString = actionString;
    }

    public String getActionString() {
        return actionString;
    }

    @JsonCreator
    public static ActionType fromString(String type) {
        for (ActionType actionType : ActionType.values()) {
            if (actionType.getActionString().equalsIgnoreCase(type)) {
                return actionType;
            }
        }
        throw new IllegalArgumentException("Unknown action type: " + type);
    }

    @JsonValue
    public String toValue() {
        return actionString;
    }
}


