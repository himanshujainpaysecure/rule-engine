package net.ps.engine.action;

import net.ps.engine.model.Order;

public class ShowPromotionAction implements Action {

    @Override
    public void execute(Order order) {
        System.out.println("Showing promotion for order " + order.id());
    }
}
