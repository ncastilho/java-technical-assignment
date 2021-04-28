package kata.supermarket;

import kata.supermarket.discounts.BuyThreeForTwoDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyThreeForTwoDiscountTest {

    @DisplayName("should apply buy three for two discount when item contains...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void shouldApplyDiscount(String description, String expectedTotal, ItemByUnit item) {
        final BuyThreeForTwoDiscount discount = new BuyThreeForTwoDiscount();
        assertEquals(new BigDecimal(expectedTotal), discount.apply(item));
    }

    static Stream<Arguments> shouldApplyDiscount() {
        return Stream.of(
                Arguments.of("0 KitKat(s)", "0.00", kitkatItems(0)),
                Arguments.of("3 KitKat(s)", "1.00", kitkatItems(3)),
                Arguments.of("2 KitKat(s)", "0.00", kitkatItems(2)),
                Arguments.of("6 KitKat(s)", "2.00", kitkatItems(6)),
                Arguments.of("30 KitKat(s)", "10.00", kitkatItems(30))
        );
    }

    private static Item kitkatItems(int units) {
        return new Product(new BigDecimal("1.00")).createItem(units, new BuyThreeForTwoDiscount());
    }
}
