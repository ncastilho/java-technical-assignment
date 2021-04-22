package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class DiscountCalculator {
    public BigDecimal calculate(Iterable<Item> items) {
        return toStream(items).map(Item::discount)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP);
    }

    private Stream<Item> toStream(Iterable<Item> items) {
        return StreamSupport.stream(items.spliterator(), false);
    }
}
