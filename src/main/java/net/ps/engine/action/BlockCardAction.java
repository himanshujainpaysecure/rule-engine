package net.ps.engine.action;

import net.ps.engine.model.Order;

/**
 * This class represents an action to block the card associated with an order.
 * It implements the {@link Action} interface and defines the {@link Action#execute(Order)} method.
 */
public class BlockCardAction implements Action {

    @Override
    public void execute(Order order) {
        System.out.println("Blocking card for order " + order.id());
    }
}
