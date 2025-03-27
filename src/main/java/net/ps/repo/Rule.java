package net.ps.repo;


import java.time.LocalDateTime;

//@Entity
public class Rule {

/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private Long id;

    private String merchantId;
    private String ruleContent; // DRL content
    private boolean active;
    private LocalDateTime lastModified;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getRuleContent() {
        return ruleContent;
    }

    public void setRuleContent(String ruleContent) {
        this.ruleContent = ruleContent;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }
}

