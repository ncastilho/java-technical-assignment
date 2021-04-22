package kata.supermarket.discounts;

import kata.supermarket.ItemByUnit;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BuyOneGetOneFreeDiscount implements Discount {

    @Override
    public BigDecimal apply(final ItemByUnit itemByUnit) {
        return new BigDecimal(itemByUnit.units()).divide(new BigDecimal(2), RoundingMode.CEILING)
                        .multiply(itemByUnit.price())
                        .setScale(2, RoundingMode.HALF_UP);
    }
}
