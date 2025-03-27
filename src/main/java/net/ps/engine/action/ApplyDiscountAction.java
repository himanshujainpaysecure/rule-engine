package net.ps.engine.action;

import net.ps.engine.model.Order;

/**
 * This class represents an action to apply a discount to an order.
 * It implements the {@link Action} interface and defines the {@link Action#execute(Order)} method.
 */
public class ApplyDiscountAction implements Action{

    @Override
    public void execute(Order order) {
        System.out.println("Applying discount for order " + order.id());
    }
}
