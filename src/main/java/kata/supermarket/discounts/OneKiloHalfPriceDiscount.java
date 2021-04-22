package kata.supermarket.discounts;

import kata.supermarket.ItemByWeight;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OneKiloHalfPriceDiscount implements Discount {

    public BigDecimal apply(ItemByWeight itemByWeight) {
        return itemByWeight.price()
                        .multiply(new BigDecimal("0.5"))
                        .setScale(2, RoundingMode.HALF_UP);
    }
}
