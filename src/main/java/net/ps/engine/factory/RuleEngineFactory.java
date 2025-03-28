package net.ps.engine.factory;

import net.ps.engine.RuleEngine;
import net.ps.engine.action.*;
import net.ps.engine.condition.*;
import net.ps.engine.mapper.ActionMapper;
import net.ps.engine.mapper.ConditionMapper;
import net.ps.engine.mapper.RuleMapper;
import net.ps.engine.rule.Rule;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Factory class responsible for creating instances of {@link RuleEngine}.
 * This class provides a method to load rule configurations from a JSON file
 * and convert them into a {@link RuleEngine} instance.
 */
public class RuleEngineFactory {

    /**
     * Creates a {@link RuleEngine} by loading rule configurations from the specified JSON file
     * and converting them into {@link Rule} objects. The rules are created by mapping each
     * {@link RuleMapper} to a new {@link Rule}, along with their associated conditions and actions.
     *
     * <p>This method loads rule configurations, processes them into a list of {@link Rule} objects,
     * and returns a {@link RuleEngine} populated with the processed rules. Each rule is constructed
     * with its name, priority, conditions, actions, and logical operator setting.</p>
     *
     * @param jsonFilePath the path to the JSON file containing the rule configurations.
     *                     This cannot be {@code null} or empty.
     * @return a new {@link RuleEngine} instance populated with the rules defined in the JSON file.
     * @throws Exception if there is an error loading the rule configurations from the JSON file
     *                   or if any issue occurs during rule processing.
     */
    public static RuleEngine createRuleEngine(String jsonFilePath) throws Exception {
        List<RuleMapper> ruleMappers = RuleEngineConfigLoader.loadRuleConfigs(jsonFilePath);
        List<Rule> rules = ruleMappers.stream()
                .map(ruleMapper -> new Rule(
                        ruleMapper.getName(),
                        ruleMapper.getPriority(),
                        ruleMapper.getConditions().stream()
                                .map(RuleEngineFactory::createCondition)
                                .collect(Collectors.toList()),
                        ruleMapper.getActions().stream()
                                .map(RuleEngineFactory::createAction)
                                .collect(Collectors.toList()),
                        ruleMapper.isUseAndLogic()
                ))
                .collect(Collectors.toList());
        return new RuleEngine(rules);
    }

    private static ConditionEvaluator createCondition(ConditionMapper conditionMapper) {
        // Convert the string condition type to the corresponding ConditionType enum
        ConditionType conditionType = ConditionType.fromString(conditionMapper.getType().getConditionString());
        return switch (conditionType) {
            case COUNTRY_CONDITION -> new CountryConditionEvaluator(conditionMapper.getValues());
            case PRICE_RANGE_CONDITION -> new PriceRangeConditionEvaluator(conditionMapper.getMin(), conditionMapper.getMax());
            case USER_TIER_CONDITION -> new UserTierConditionEvaluator(conditionMapper.getValues());
            default -> throw new IllegalArgumentException("Unknown condition type: " + conditionType);
        };
    }

    private static Action createAction(ActionMapper actionMapper) {
        // Convert the string action type to the corresponding ActionType enum
        ActionType actionType = ActionType.fromString(actionMapper.getType().getActionString());
        return switch (actionType) {
            case BLOCK_CARD -> new BlockCardAction();
            case SEND_EMAIL -> new SendEmailAction();
            case APPLY_DISCOUNT -> new ApplyDiscountAction();
            default -> throw new IllegalArgumentException("Unknown action type: " + actionType);
        };
    }
}

