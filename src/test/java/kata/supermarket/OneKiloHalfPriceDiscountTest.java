package kata.supermarket;

import kata.supermarket.discounts.OneKiloHalfPriceDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OneKiloHalfPriceDiscountTest {

    @DisplayName("should apply half price discount when weight is...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void shouldApplyDiscount(String description, String expectedTotal, ItemByWeight item) {
        final OneKiloHalfPriceDiscount discount = new OneKiloHalfPriceDiscount();
        assertEquals(new BigDecimal(expectedTotal), discount.apply(item));
    }

    static Stream<Arguments> shouldApplyDiscount() {
        return Stream.of(
                Arguments.of("250g", "0.63", twoFiftyGramsAtHalfPrice()),
                Arguments.of("1 kg", "2.50", oneKiloAtHalfPrice()),
                Arguments.of("0 kg", "0.00", zeroKilosAtHalfPrice())
        );
    }

    private static WeighedProduct aKiloOfAmericanSweets() {
        return new WeighedProduct(new BigDecimal("4.99"));
    }

    private static Item twoFiftyGramsAtHalfPrice() {
        return aKiloOfAmericanSweets().weighing(new BigDecimal(".25"), new OneKiloHalfPriceDiscount());
    }

    private static Item oneKiloAtHalfPrice() {
        return aKiloOfAmericanSweets().weighing(new BigDecimal("1"), new OneKiloHalfPriceDiscount());
    }

    private static Item zeroKilosAtHalfPrice() {
        return aKiloOfAmericanSweets().weighing(new BigDecimal("0"), new OneKiloHalfPriceDiscount());
    }
}
