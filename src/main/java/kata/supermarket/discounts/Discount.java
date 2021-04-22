package kata.supermarket.discounts;

import kata.supermarket.ItemByUnit;
import kata.supermarket.ItemByWeight;

import java.math.BigDecimal;

public interface Discount {

    default BigDecimal apply(final ItemByWeight itemByWeight) {
        return BigDecimal.ZERO;
    }

    default BigDecimal apply(final ItemByUnit itemByUnit) {
        return BigDecimal.ZERO;
    }
}
