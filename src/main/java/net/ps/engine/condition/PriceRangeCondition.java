package net.ps.engine.condition;

import net.ps.engine.model.Order;

/**
 * The {@code PriceRangeCondition} class implements the {@link Condition} interface and represents
 * a condition for filtering orders based on a price range. It checks whether an order's total amount
 * falls within a specified minimum and maximum price range.
 * <p>
 * This class provides methods to evaluate whether a given order meets the price range condition.
 * </p>
 */
public class PriceRangeCondition implements Condition {

    private final double minPrice;
    private final double maxPrice;

    public PriceRangeCondition(double minPrice, double maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    /**
     * Tests whether the specified {@link Order} meets the price range condition.
     * The order's total amount must be greater than or equal to the minimum price
     * and less than or equal to the maximum price for the condition to be true.
     *
     * @param order The order to be tested.
     * @return {@code true} if the order's total amount is within the specified price range,
     *         {@code false} otherwise.
     */
    @Override
    public boolean test(Order order) {
        return order.totalDeposit() >= minPrice && order.totalDeposit() <= maxPrice;
    }

    /**
     * Evaluates whether the specified {@link Order} meets the price range condition.
     * This method is equivalent to {@link #test(Order)} and is provided for flexibility
     * in evaluating conditions in different contexts.
     *
     * @param order The order to be evaluated.
     * @return {@code true} if the order's total amount is within the specified price range,
     *         {@code false} otherwise.
     */
    @Override
    public boolean evaluate(Order order) {
        return order.totalDeposit() >= minPrice && order.totalDeposit() <= maxPrice;
    }
}

