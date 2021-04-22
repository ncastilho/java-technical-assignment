package kata.supermarket.discounts;

import kata.supermarket.ItemByWeight;

import java.math.BigDecimal;

public interface Discount {

    BigDecimal apply(final ItemByWeight itemByWeight);
}
