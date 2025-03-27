package net.ps.engine.action;

import net.ps.engine.model.Order;

/**
 * This class represents an action to send an email related to an order.
 * It implements the {@link Action} interface and defines the {@link Action#execute(Order)} method.
 */
public class SendEmailAction implements Action {
    @Override
    public void execute(Order order) {
        System.out.println("Sending email for order " + order.id());
    }
}
