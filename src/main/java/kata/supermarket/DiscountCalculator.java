package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountCalculator {
    public BigDecimal total(Iterable<Item> items) {
        return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
    }
}
