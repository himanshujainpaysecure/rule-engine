package net.ps.engine.action;

import net.ps.engine.model.Order;

/**
 * Represents an action that can be performed on an {@link Order}.
 * This interface defines a single method, {@link #execute(Order)}, which executes
 * a specific action on an order.
 */
public interface Action {
    void execute(Order order);
}
