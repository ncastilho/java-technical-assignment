package kata.supermarket;

import kata.supermarket.discounts.Discount;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemByUnit implements Item {

    private final Product product;
    private final int units;
    private final Discount discount;

    ItemByUnit(final Product product, int units, final Discount discount) {
        this.product = product;
        this.units = units;
        this.discount = discount;
    }

    public BigDecimal price() {
        return pricePerUnit().multiply(new BigDecimal(units)).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal pricePerUnit() {
        return product.pricePerUnit();
    }

    public int units() {
        return units;
    }

    @Override
    public BigDecimal discount() {
        return discount.apply(this);
    }

}
