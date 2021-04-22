package kata.supermarket;

import kata.supermarket.discounts.OneKiloHalfPriceDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountCalculatorTest {

    @DisplayName("should calculate total items discount when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void shouldCalculateTotalDiscounts(String description, String expectedTotal, Iterable<Item> items) {
        final DiscountCalculator calculator = new DiscountCalculator();
        assertEquals(new BigDecimal(expectedTotal), calculator.calculate(items));
    }

    static Stream<Arguments> shouldCalculateTotalDiscounts() {
        return Stream.of(
                noItems(),
                aSingleItemPricedByWeightHalfPrice(),
                multipleItemsPricedByWeightHalfPrice()
        );
    }

    private static Arguments noItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList());
    }

    private static Arguments aSingleItemPricedByWeightHalfPrice() {
        return Arguments.of("a single weighed item", "0.63", Collections.singleton(twoFiftyGramsOfAmericanSweetsHalfPrice()));
    }

    private static Arguments multipleItemsPricedByWeightHalfPrice() {
        return Arguments.of("multiple weighed items", "0.93",
                Arrays.asList(twoFiftyGramsOfAmericanSweetsHalfPrice(), twoHundredGramsOfPickAndMixHalfPrice())
        );
    }

    private static WeighedProduct aKiloOfAmericanSweets() {
        return new WeighedProduct(new BigDecimal("4.99"));
    }

    private static Item twoFiftyGramsOfAmericanSweetsHalfPrice() {
        return aKiloOfAmericanSweets().weighing(new BigDecimal(".25"), new OneKiloHalfPriceDiscount());
    }

    private static WeighedProduct aKiloOfPickAndMix() {
        return new WeighedProduct(new BigDecimal("2.99"));
    }

    private static Item twoHundredGramsOfPickAndMixHalfPrice() {
        return aKiloOfPickAndMix().weighing(new BigDecimal(".2"), new OneKiloHalfPriceDiscount());
    }

}
