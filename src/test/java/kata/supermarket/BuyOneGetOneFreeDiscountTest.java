package kata.supermarket;

import kata.supermarket.discounts.BuyOneGetOneFreeDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyOneGetOneFreeDiscountTest {

    @DisplayName("should apply buy one get one free discount when item contains...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void shouldApplyDiscount(String description, String expectedTotal, ItemByUnit item) {
        final BuyOneGetOneFreeDiscount discount = new BuyOneGetOneFreeDiscount();
        assertEquals(new BigDecimal(expectedTotal), discount.apply(item));
    }

    static Stream<Arguments> shouldApplyDiscount() {
        return Stream.of(
                Arguments.of("1 units", "0.00", oneUnitsAtBuyOneGetOneFree()),
                Arguments.of("2 units", "0.49", twoUnitsAtBuyOneGetOneFree()),
                Arguments.of("3 units", "0.49", threeUnitsAtBuyOneGetOneFree()),
                Arguments.of("4 units", "0.98", fourUnitsAtBuyOneGetOneFree())
        );
    }

    private static Item oneUnitsAtBuyOneGetOneFree() {
        return new Product(new BigDecimal("0.49")).createItem(1, new BuyOneGetOneFreeDiscount());
    }

    private static Item twoUnitsAtBuyOneGetOneFree() {
        return new Product(new BigDecimal("0.49")).createItem(2, new BuyOneGetOneFreeDiscount());
    }

    private static Item threeUnitsAtBuyOneGetOneFree() {
        return new Product(new BigDecimal("0.49")).createItem(3, new BuyOneGetOneFreeDiscount());
    }

    private static Item fourUnitsAtBuyOneGetOneFree() {
        return new Product(new BigDecimal("0.49")).createItem(4, new BuyOneGetOneFreeDiscount());
    }
}
