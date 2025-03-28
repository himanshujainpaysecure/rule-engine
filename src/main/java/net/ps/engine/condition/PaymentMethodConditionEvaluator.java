package net.ps.engine.condition;

import net.ps.engine.model.Order;
import java.util.Set;

public class PaymentMethodConditionEvaluator implements ConditionEvaluator {

    private final Set<String> paymentMethods;

    public PaymentMethodConditionEvaluator(Set<String> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    @Override
    public boolean test(Order order) {
        return paymentMethods.contains(order.paymentMethod().getPaymentMethodStr());
    }

    @Override
    public boolean evaluate(Order order) {
        return paymentMethods.contains(order.paymentMethod().getPaymentMethodStr());
    }
}

