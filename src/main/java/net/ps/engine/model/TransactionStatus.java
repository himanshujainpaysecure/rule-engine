package net.ps.engine.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionStatus {
    SUCCESS("Success"),
    REJECTED("Rejected"),
    PENDING("Pending");

    private final String txnStatus;

    TransactionStatus(String txnStatus) {
        this.txnStatus = txnStatus;
    }

    public String getTxnStatusStr() {
        return txnStatus;
    }

    @JsonCreator
    public static TransactionStatus fromString(String txnStatusStr) {
        for (TransactionStatus txnStatus : TransactionStatus.values()) {
            if (txnStatus.getTxnStatusStr().equalsIgnoreCase(txnStatusStr)) {
                return txnStatus;
            }
        }
        throw new IllegalArgumentException("Unknown condition type: " + txnStatusStr);
    }

    @JsonValue
    public String toValue() {
        return txnStatus;
    }
}
