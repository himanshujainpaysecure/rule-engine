package net.ps.engine.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.ps.engine.mapper.RuleMapper;
import net.ps.engine.mapper.RulesContainer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RuleEngineConfigLoader {

    public static List<RuleMapper> loadRuleConfigs(String resourcePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // Deserialize JSON into a list of RuleConfig objects
        try (InputStream inputStream = RuleEngineConfigLoader.class.getClassLoader()
                .getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("File not found: " + resourcePath);
            }
            RulesContainer rulesContainer = objectMapper.readValue(inputStream, RulesContainer.class);
            return rulesContainer.getRules();
        }
    }
}

