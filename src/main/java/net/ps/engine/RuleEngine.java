package net.ps.engine;

import net.ps.engine.model.Order;
import net.ps.engine.rule.Rule;

import java.util.List;

/**
 * The {@link RuleEngine} class is responsible for applying a set of rules to an {@link Order}.
 * It manages the list of rules and provides functionality to evaluate and apply those rules based
 * on their priority and the conditions defined for the order.
 *
 * <p>This class processes the rules by sorting them according to their priority,
 * filtering out the ones that don't match the given order, and executing the actions of
 * all the matching rules.</p>
 */
public class RuleEngine {
    private final List<Rule> rules;

    public RuleEngine(List<Rule> rules) {
        this.rules = rules;
    }

    /**
     * Applies a set of rules to the given {@link Order}.
     * The rules are first sorted by priority (highest priority first),
     * then filtered to include only those that match the given order's conditions.
     * Finally, the actions of all matching rules are executed.
     *
     * <p>This method uses streams to process the rules. The rules are sorted by priority,
     * filtered based on their evaluation of the {@link Order}, and then actions are executed
     * for all matching rules.</p>
     *
     * @param order the {@link Order} to which the rules will be applied.
     *              This cannot be {@code null}.
     */
    public void applyRules(Order order) {
        rules.stream()
                .sorted((r1, r2) -> Integer.compare(r2.getPriority(), r1.getPriority()))  // Sorting by priority
                .filter(rule -> rule.evaluate(order))  // Filter rules that match the conditions
                .forEach(rule -> rule.executeActions(order));  // Execute actions
    }
}

