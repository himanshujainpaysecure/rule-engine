package net.ps.config;

import net.ps.repo.RuleRepository;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;

@Configuration
public class DroolsConfig {

    @Autowired
    private RuleRepository ruleRepository;

    @Bean
    public KieContainer kieContainer() throws IOException {
        KieServices ks = KieServices.Factory.get();
        KieFileSystem kfs = ks.newKieFileSystem();

        // Load DRL file from file system
        // Load DRL files from classpath or file system
        kfs.write("src/main/resources/rules/PaymentGatewayRules.drl",
                ks.getResources().newClassPathResource("rules/PaymentGatewayRules.drl"));
        //FileInputStream fis = new FileInputStream("src/main/resources/rules/PaymentGatewayRules.drl");
        //kfs.read(fis.toString());
       /* kfs.write("src/main/resources/your/rules.drl",
                ks.getResources().newInputStreamResource(fis));*/

       /* // Load rules from database
        ruleRepository.findAll().get().forEach(rule ->
                kfs.write("src/main/resources/rules/" + rule.getId() + ".drl",
                        ks.getResources().newReaderResource(new StringReader(rule.getRuleContent())))
        );*/

        KieBuilder kieBuilder = ks.newKieBuilder(kfs).buildAll();
        Results results = kieBuilder.getResults();
        // Check for errors in rule definitions
        if (results.hasMessages(org.kie.api.builder.Message.Level.ERROR)) {
            throw new RuntimeException("Error building rules: " + results.getMessages());
        }

        return ks.newKieContainer(kieBuilder.getKieModule().getReleaseId());
    }

    //return ks.newKieContainer(kieBuilder.getKieModule().getReleaseId());

    @Bean
    public KieSession kieSession(KieContainer kieContainer) {
        return kieContainer.newKieSession();
    }

    @Bean
    public KieScanner kieScanner(KieContainer kieContainer) {
        KieServices kieServices = KieServices.Factory.get();

        // Create and configure KieScanner
        KieScanner kieScanner = kieServices.newKieScanner(kieContainer);

        // Start scanning for updates every 10 seconds
        kieScanner.start(10000L);

        return kieScanner;
    }
}





