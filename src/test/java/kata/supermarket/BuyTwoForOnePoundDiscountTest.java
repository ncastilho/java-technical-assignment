package kata.supermarket;

import kata.supermarket.discounts.BuyTwoForOnePoundDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyTwoForOnePoundDiscountTest {

    @DisplayName("should apply buy two for £1 discount when item contains...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void shouldApplyDiscount(String description, String expectedTotal, ItemByUnit item) {
        final BuyTwoForOnePoundDiscount discount = new BuyTwoForOnePoundDiscount();
        assertEquals(new BigDecimal(expectedTotal), discount.apply(item));
    }

    static Stream<Arguments> shouldApplyDiscount() {
        return Stream.of(
                Arguments.of("1 units (less than £1)", "0.00", oneUnitAtBuyTwoForOnePound()),
                Arguments.of("2 units (less than £1)", "0.00", twoUnitAtBuyTwoForOnePound()),
                Arguments.of("3 units (greater than £1)", "0.10", threeUnitAtBuyTwoForOnePound()),
                Arguments.of("4 units (greater than £1)", "0.20", fourUnitAtBuyTwoForOnePound())
        );
    }

    private static Item oneUnitAtBuyTwoForOnePound() {
        return new Product(new BigDecimal("0.49")).createItem(1, new BuyTwoForOnePoundDiscount());
    }

    private static Item twoUnitAtBuyTwoForOnePound() {
        return new Product(new BigDecimal("0.49")).createItem(2, new BuyTwoForOnePoundDiscount());
    }

    private static Item threeUnitAtBuyTwoForOnePound() {
        return new Product(new BigDecimal("0.55")).createItem(3, new BuyTwoForOnePoundDiscount());
    }

    private static Item fourUnitAtBuyTwoForOnePound() {
        return new Product(new BigDecimal("0.55")).createItem(4, new BuyTwoForOnePoundDiscount());
    }
}
