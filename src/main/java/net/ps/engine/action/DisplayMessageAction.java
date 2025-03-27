package net.ps.engine.action;

import net.ps.engine.model.Order;

public class DisplayMessageAction implements Action {

    @Override
    public void execute(Order order) {
        System.out.println("Displaying message for order " + order.id());
    }
}
