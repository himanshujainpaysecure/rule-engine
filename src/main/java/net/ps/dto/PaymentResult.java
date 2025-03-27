package net.ps.dto;

public class PaymentResult {
    private boolean approved; // Indicates if the payment was approved
    private String reason; // Reason for approval or rejection
    private String transactionId; // Unique identifier for the transaction
    private double discount; // Any discount applied to the payment
    private double finalAmount; // The final amount after discounts
    private String gateway; // The final amount after discounts

    // Constructor
    public PaymentResult() {
        this.approved = false;
        this.reason = "";
        this.transactionId = "";
        this.discount = 0.0;
        this.finalAmount = 0.0;
        this.gateway = "";
    }

    // Getters and Setters


    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }
}

