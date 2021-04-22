package kata.supermarket;

import kata.supermarket.discounts.Discount;
import kata.supermarket.discounts.NoDiscount;

import java.math.BigDecimal;

public class WeighedProduct {

    private final BigDecimal pricePerKilo;

    public WeighedProduct(final BigDecimal pricePerKilo) {
        this.pricePerKilo = pricePerKilo;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos, new NoDiscount());
    }

    public Item weighing(final BigDecimal kilos, final Discount discount) {
        return new ItemByWeight(this, kilos, discount);
    }
}
