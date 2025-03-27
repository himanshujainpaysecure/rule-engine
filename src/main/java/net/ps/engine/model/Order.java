package net.ps.engine.model;

import java.math.BigDecimal;

public record Order(int id,
                    String country,
                    double totalDeposit,
                    UserTier userTier,
                    PaymentMethod paymentMethod,
                    TransactionStatus txnStatus,
                    BigDecimal txnAmount) {
}
