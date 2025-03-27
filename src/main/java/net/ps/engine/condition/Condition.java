package net.ps.engine.condition;

import net.ps.engine.model.Order;
import java.util.function.Predicate;

/**
 * Represents a condition that can be evaluated on an {@link Order}.
 * This interface extends {@link Predicate} and adds an {@link #evaluate(Order)}
 * method for evaluating the condition against an order.
 */
public interface Condition extends Predicate<Order> {
    boolean evaluate(Order order);
}

