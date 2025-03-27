package net.ps.engine.action;

import net.ps.engine.model.Order;

public class ShowPaymentMethodAction implements Action {

    @Override
    public void execute(Order order) {
        System.out.println("Show payment method for order " + order.id());
    }
}
