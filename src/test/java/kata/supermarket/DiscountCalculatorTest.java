package kata.supermarket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountCalculatorTest {

    @DisplayName("should calculate total items discount when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void shouldCalculateTotalDiscounts(String description, String expectedTotal, Iterable<Item> items) {
        final DiscountCalculator calculator = new DiscountCalculator();
        assertEquals(new BigDecimal(expectedTotal), calculator.total(items));
    }

    static Stream<Arguments> shouldCalculateTotalDiscounts() {
        return Stream.of(noItems());
    }

    private static Arguments noItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList());
    }

}
