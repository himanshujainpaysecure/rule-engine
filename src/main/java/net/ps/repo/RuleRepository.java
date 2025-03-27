package net.ps.repo;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Configuration
public class RuleRepository {

    public Optional<List<Rule>> findAll(){
        Rule rule1 = new Rule();
        rule1.setId(1234L);
        rule1.setMerchantId("MERCHANT1");
        rule1.setRuleContent("rule \"High Risk Payment Block\"\nwhen\n    $p: PaymentRequest(amount > 50000)\nthen\n    $p.setApproved(false);\nend");
        rule1.setActive(true);
        rule1.setLastModified(LocalDateTime.now());

        Rule rule2 = new Rule();
        rule2.setId(9845L);
        rule2.setMerchantId("MERCHANT2");
        rule2.setRuleContent("rule \"Preferred Merchant Discount\"\nwhen\n    $p: PaymentRequest(merchantTier == \"PREMIUM\")\nthen\n    $p.setDiscount(0.05);\nend");
        rule2.setActive(true);
        rule2.setLastModified(LocalDateTime.now());

        return Optional.of(Arrays.asList(rule1, rule2));
    }
    public Optional<Rule> findByMerchantId(){
        Rule rule2 = new Rule();
        rule2.setId(1234L);
        rule2.setMerchantId("MERCHANT2");
        rule2.setRuleContent("rule \"Preferred Merchant Discount\"\nwhen\n    $p: PaymentRequest(merchantTier == \"PREMIUM\")\nthen\n    $p.setDiscount(0.05);\nend");
        rule2.setActive(true);
        rule2.setLastModified(LocalDateTime.now());
        return Optional.of(rule2);
    }

}

