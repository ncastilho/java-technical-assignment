package kata.supermarket;

import kata.supermarket.discounts.Discount;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemByWeight implements Item {

    private final WeighedProduct product;
    private final BigDecimal weightInKilos;
    private final Discount discount;

    ItemByWeight(final WeighedProduct product, final BigDecimal weightInKilos, final Discount discount) {
        this.product = product;
        this.weightInKilos = weightInKilos;
        this.discount = discount;
    }

    public BigDecimal price() {
        return product.pricePerKilo().multiply(weightInKilos).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal discount() {
        return discount.apply(this);
    }
}
