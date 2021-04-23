package kata.supermarket.discounts;

import kata.supermarket.ItemByUnit;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BuyTwoForOnePoundDiscount implements Discount {

    @Override
    public BigDecimal apply(final ItemByUnit itemByUnit) {
        if (itemByUnit.price().compareTo(BigDecimal.ONE) <= 0) {
            return BigDecimal.ZERO
                    .setScale(2, RoundingMode.HALF_UP);
        }

        final BigDecimal nearestEvenUnits = new BigDecimal(itemByUnit.units() / 2).multiply(new BigDecimal(2)).setScale(0, RoundingMode.DOWN);

         final BigDecimal discount = nearestEvenUnits.multiply(itemByUnit.pricePerUnit())
                .subtract(new BigDecimal(itemByUnit.units())
                        .divide(new BigDecimal(2), RoundingMode.FLOOR));

         if (discount.compareTo(BigDecimal.ZERO) < 0) {
             return BigDecimal.ZERO
                     .setScale(2, RoundingMode.HALF_UP);
         }

         return discount;
    }
}
