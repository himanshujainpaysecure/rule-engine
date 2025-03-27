package net.ps.dto;

public class PaymentRequest {
    private double amount;
    private String currency;
    private String merchantId;
    private String merchantTier;
    private double merchantRiskScore;
    private boolean approved;
    private String reason;
    private double discount;
    private String gateway;
    private PaymentResult result;

    public PaymentRequest(double amount, String currency, String merchantId, String merchantTier, double merchantRiskScore, boolean approved, String reason, double discount, String gateway, PaymentResult result) {
        this.amount = 0.00;
        this.currency = "";
        this.merchantId = "";
        this.merchantTier = "";
        this.merchantRiskScore = 0.0;
        this.approved = false;
        this.reason = "";
        this.discount = 0.2;
        this.gateway = "";
        this.result = result;
    }

    public PaymentRequest() {
    }

    public PaymentResult getResult() {
        return result;
    }

    public void setResult(PaymentResult result) {
        this.result = result;
    }

    // Getters and Setters
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantTier() {
        return merchantTier;
    }

    public void setMerchantTier(String merchantTier) {
        this.merchantTier = merchantTier;
    }

    public double getMerchantRiskScore() {
        return merchantRiskScore;
    }

    public void setMerchantRiskScore(double merchantRiskScore) {
        this.merchantRiskScore = merchantRiskScore;
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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }
}

