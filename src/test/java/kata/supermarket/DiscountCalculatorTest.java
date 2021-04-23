package kata.supermarket;

import kata.supermarket.discounts.BuyOneGetOneFreeDiscount;
import kata.supermarket.discounts.BuyTwoForOnePoundDiscount;
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
                multipleItemsPricedByWeightHalfPrice(),
                multipleItemsPricedPerUnitTwoForOnePound(),
                multipleItemsPricedPerUnitBuyOneGetOneFree()
        );
    }

    private static Arguments aSingleItemPricedByWeightHalfPrice() {
        return Arguments.of("a single weighed item with one kilo half price", "0.63", Collections.singleton(twoFiftyGramsOfAmericanSweetsHalfPrice()));
    }

    private static Arguments multipleItemsPricedByWeightHalfPrice() {
        return Arguments.of("multiple weighed items with one kilo half price", "0.93",
                Arrays.asList(twoFiftyGramsOfAmericanSweetsHalfPrice(), twoHundredGramsOfPickAndMixHalfPrice())
        );
    }

    private static Arguments multipleItemsPricedPerUnitTwoForOnePound() {
        return Arguments.of("multiple items priced per unit with two for one", "0.00",
                Collections.singletonList(aPintOfMilk()));
    }

    private static Arguments multipleItemsPricedPerUnitBuyOneGetOneFree() {
        return Arguments.of("multiple items priced per unit with buy one get one free", "1.55",
                Collections.singletonList(aPackOfDigestives()));
    }

    private static Arguments noItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList());
    }

    private static Item aPintOfMilk() {
        return new Product(new BigDecimal("0.49")).createItem(3, new BuyTwoForOnePoundDiscount());
    }

    private static Item aPackOfDigestives() {
        return new Product(new BigDecimal("1.55")).createItem(3, new BuyOneGetOneFreeDiscount());
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
