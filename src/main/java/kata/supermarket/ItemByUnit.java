package kata.supermarket;

import kata.supermarket.discounts.Discount;

import java.math.BigDecimal;

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
