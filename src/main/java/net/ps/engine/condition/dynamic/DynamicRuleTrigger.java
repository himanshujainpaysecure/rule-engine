package net.ps.engine.condition.dynamic;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicRuleTrigger {

    public static void main(String[] args) {
        // Step 1: Create the condition evaluators
        ConditionEval simpleConditionEvaluator = new SimpleConditionEvaluator();
        ConditionEval complexConditionEvaluator = new ComplexConditionEvaluator();

        // Step 2: Create the rule engine service with the complex evaluator
        RuleEngineService ruleEngineService = new RuleEngineService();
        ruleEngineService.setConditionEvaluator(complexConditionEvaluator);  // Use complex evaluator

        // Step 3: Define the conditions with AND, OR, and NOT
        Condition condition1 = new Condition("country", "equals", "England");
        Condition condition2 = new Condition("totalDeposit", "greaterThan", 10000);
        Condition condition3 = new Condition("totalDeposit", "lessThan", 20000);
        Condition condition4 = new Condition("userTier", "equals", "premium");

        // Define a complex condition using AND logic
        Condition andCondition = new Condition("AND", condition2, condition3);  // totalDeposit > 10000 AND totalDeposit < 20000

        // Define a complex condition using OR logic
        Condition orCondition = new Condition("OR", condition1, condition4);  // country = "England" OR userTier = "premium"

        // Define a complex condition using NOT logic
        Condition notCondition = new Condition("NOT", condition4, null);  // NOT (userTier = "premium")

        // Combine all complex conditions using AND logic
        Condition combinedCondition = new Condition("AND", andCondition, orCondition);  // (totalDeposit > 10000 AND totalDeposit < 20000) AND (country = "England" OR userTier = "premium")

        // Step 4: Define actions for the rule
        List<String> actions = Arrays.asList("Block card", "Send email");

        // Step 5: Create the rule with conditions and actions
        Rule rule = new Rule("Block Card on Fraudulent Transaction", 1, Arrays.asList(combinedCondition), actions);

        // Step 6: Define input data to simulate a transaction or user data
        Map<String, Object> inputData = new HashMap<>();
        inputData.put("country", "England");
        inputData.put("totalDeposit", 15000);
        inputData.put("userTier", "premium");

        // Step 7: Evaluate the rule with the input data
        System.out.println("Evaluating rule: " + rule.getRuleName());
        ruleEngineService.evaluateRules(Arrays.asList(rule), inputData);
    }
}

