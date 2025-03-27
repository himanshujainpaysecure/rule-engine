package net.ps.engine.action;

import net.ps.engine.model.Order;

/**
 * This class represents an action to block future transactions for an order.
 * It implements the {@link Action} interface and defines the {@link Action#execute(Order)} method.
 * */
public class BlockFutureTxnAction implements Action {

    @Override
    public void execute(Order order) {
        System.out.println("Blocking future txn for order " + order.id());
    }
}
