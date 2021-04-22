package kata.supermarket;

import kata.supermarket.discounts.Discount;
import kata.supermarket.discounts.NoDiscount;

import java.math.BigDecimal;

public class Product {

    private final BigDecimal pricePerUnit;

    public Product(final BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this, 1, new NoDiscount());
    }

    public Item createItem(final int units, final Discount discount) {
        return new ItemByUnit(this, units, discount);
    }
}
