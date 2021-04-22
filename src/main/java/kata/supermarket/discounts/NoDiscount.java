package kata.supermarket.discounts;

import kata.supermarket.ItemByWeight;

import java.math.BigDecimal;

public class NoDiscount implements Discount {

    @Override
    public BigDecimal apply(ItemByWeight itemByWeight) {
        return BigDecimal.ZERO;
    }
}
