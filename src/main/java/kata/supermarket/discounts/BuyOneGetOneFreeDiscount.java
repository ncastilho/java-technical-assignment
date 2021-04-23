package kata.supermarket.discounts;

import kata.supermarket.ItemByUnit;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BuyOneGetOneFreeDiscount implements Discount {

    @Override
    public BigDecimal apply(final ItemByUnit itemByUnit) {
        return new BigDecimal(itemByUnit.units() / 2)
                .multiply(itemByUnit.pricePerUnit())
                        .setScale(2, RoundingMode.HALF_UP);
    }
}
