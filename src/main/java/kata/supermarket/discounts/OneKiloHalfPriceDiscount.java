package kata.supermarket.discounts;

import kata.supermarket.ItemByWeight;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OneKiloHalfPriceDiscount implements Discount {

    public BigDecimal apply(ItemByWeight itemByWeight) {
        final BigDecimal discountedPrice = itemByWeight.price().multiply(new BigDecimal("0.5"));

        return itemByWeight.price()
                .subtract(discountedPrice)
                .setScale(2, RoundingMode.HALF_UP);
    }
}
