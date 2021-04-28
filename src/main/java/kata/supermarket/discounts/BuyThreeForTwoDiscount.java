package kata.supermarket.discounts;

import kata.supermarket.ItemByUnit;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BuyThreeForTwoDiscount implements Discount {

    @Override
    public BigDecimal apply(ItemByUnit itemByUnit) {
        int amountOfDiscounts = itemByUnit.units() / 3;

        return itemByUnit.pricePerUnit().multiply(new BigDecimal(amountOfDiscounts))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
