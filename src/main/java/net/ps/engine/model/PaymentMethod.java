package net.ps.engine.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentMethod {
    CREDIT_CARD("CreditCard"),
    E_WALLET("EWallet"),
    BANK_TRANSFER("BankTransfer"),
    BUY_NOW_PAY_LATER("BuyNowPayLater"),
    CRYPTO("Crypto");

    private final String paymentMethod;

    PaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethodStr() {
        return paymentMethod;
    }

    @JsonCreator
    public static PaymentMethod fromString(String paymentMethodStr) {
        for (PaymentMethod paymentMethod : PaymentMethod.values()) {
            if (paymentMethod.getPaymentMethodStr().equalsIgnoreCase(paymentMethodStr)) {
                return paymentMethod;
            }
        }
        throw new IllegalArgumentException("Unknown condition type: " + paymentMethodStr);
    }

    @JsonValue
    public String toValue() {
        return paymentMethod;
    }
}
