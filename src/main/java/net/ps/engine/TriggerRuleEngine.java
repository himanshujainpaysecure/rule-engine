package net.ps.engine;

import net.ps.engine.factory.RuleEngineFactory;
import net.ps.engine.model.Order;
import net.ps.engine.model.PaymentMethod;
import net.ps.engine.model.TransactionStatus;
import net.ps.engine.model.UserTier;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TriggerRuleEngine {

    public static void main(String[] args) throws Exception {
        // Load the rule engine configuration from a JSON file

        // Start benchmarking
        long startTime = System.nanoTime();

        // Generate 1 million orders
        List<Order> orders = generateOrders(1_000_000);

        RuleEngine ruleEngine = RuleEngineFactory.createRuleEngine("rules/RuleJson.json");
        // Apply rules to the order
        orders.forEach(ruleEngine::applyRules);
        //ruleEngine.applyRules(order);

        // End benchmarking
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        // Convert to milliseconds and print the result
        double seconds = duration / 1_000_000_000.0;
        System.out.println("Time taken to process 1 million orders: " + seconds + " seconds.");



        /*List<Order> orders = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Order order = new Order(
                    i, // id
                    getRandomCountry(),
                    getRandomTotalDeposit(),
                    getRandomUserTier(),
                    getRandomPaymentMethod(),
                    getRandomTransactionStatus(),
                    BigDecimal.valueOf(getRandomTxnAmount())
            );
            orders.add(order);
        }

        orders.forEach(System.out::println);
*/

    }

    // Helper method to generate a list of orders
    private static List<Order> generateOrders(int numberOfOrders) {
        List<Order> orders = new ArrayList<>(numberOfOrders);

        for (int i = 1; i <= numberOfOrders; i++) {
            Order order = new Order(
                    i, // id
                    getRandomCountry(), // country
                    getRandomTotalDeposit(), // totalDeposit
                    getRandomUserTier(), // userTier
                    getRandomPaymentMethod(), // paymentMethod
                    getRandomTransactionStatus(), // txnStatus
                    BigDecimal.valueOf(getRandomTxnAmount()) // txnAmount
            );
            orders.add(order);
        }

        return orders;
    }

    // Helper method to get random country
    private static String getRandomCountry() {
        String[] countries = {"USA", "Canada", "UK", "Germany", "Australia", "India"};
        return countries[new Random().nextInt(countries.length)];
    }

    // Helper method to get random total deposit
    private static double getRandomTotalDeposit() {
        return 100 + (5000 - 100) * new Random().nextDouble(); // Random between 100 and 5000
    }

    // Helper method to get random user tier
    private static UserTier getRandomUserTier() {
        UserTier[] tiers = UserTier.values();
        return tiers[new Random().nextInt(tiers.length)];
    }

    // Helper method to get random payment method
    private static PaymentMethod getRandomPaymentMethod() {
        PaymentMethod[] methods = PaymentMethod.values();
        return methods[new Random().nextInt(methods.length)];
    }

    // Helper method to get random transaction status
    private static TransactionStatus getRandomTransactionStatus() {
        TransactionStatus[] statuses = TransactionStatus.values();
        return statuses[new Random().nextInt(statuses.length)];
    }

    // Helper method to get random transaction amount
    private static double getRandomTxnAmount() {
        return 50 + (1000 - 50) * new Random().nextDouble(); // Random between 50 and 1000
    }
}

