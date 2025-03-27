package net.ps.controller;

import net.ps.dto.PaymentRequest;
import net.ps.dto.PaymentResult;
import net.ps.repo.Rule;
import net.ps.repo.RuleRepository;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/rules")
public class RuleController {

    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private KieScanner kieScanner;

    @Autowired
    private KieContainer kieContainer;

    @GetMapping("/{merchantId}")
    public ResponseEntity<?> updateRules() {

        /*Rule rule = ruleRepository.findByMerchantId()
                .orElse(new Rule());

        rule.setMerchantId(merchantId);
        rule.setRuleContent(drlContent);
        rule.setActive(true);
        rule.setLastModified(LocalDateTime.now());*/

        //ruleRepository.save(rule);
        kieScanner.scanNow(); // Trigger rule reload


        KieSession kSession = kieContainer.newKieSession();
        PaymentRequest payment = new PaymentRequest();
        payment.setMerchantId("MERCHANT1");
        payment.setAmount(6500.0);
        payment.setCurrency("USD");
        payment.setMerchantTier("PREMIUM");

        kSession.insert(payment);
        kSession.fireAllRules();
        kSession.dispose();

        if (payment.getResult() != null) {
            PaymentResult result = payment.getResult();
            System.out.println(result.getReason());
            System.out.println(result.getDiscount());
            System.out.println(result.getFinalAmount());
            System.out.println(result.getTransactionId());
            System.out.println(result.isApproved());
            System.out.println(result.getGateway());

        } else {
            System.out.println("No result was set for this payment.");
        }


        return ResponseEntity.ok(payment.getResult());
    }
}

