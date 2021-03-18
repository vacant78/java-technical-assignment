package kata.supermarket;

import static kata.supermarket.ProductsAndItemsUtils.aSingleItemPricedPerUnit;
import static kata.supermarket.ProductsAndItemsUtils.noItems;
import static kata.supermarket.ProductsAndItemsUtils.weighedItemPricedPerKiloWithBuy1KiloForHalfPriceDiscount;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BasketWithBuy1KiloForHalfPriceDiscountTest {

    @DisplayName("basket with Buy1KiloForHalfPrice discount provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValue(String description, BigDecimal expectedTotal, Iterable<Item> items) {
        final Basket basket = new Basket();
        basket.addDiscounts(ImmutableList.of(new Buy1KiloForHalfPrice()));
        items.forEach(basket::add);
        assertEquals(expectedTotal, basket.total());
    }

    static Stream<Arguments> basketProvidesTotalValue() {
        return Stream.of(
            discountedBy(noItems(), "0.0"),
            discountedBy(aSingleItemPricedPerUnit(), "0.0"),
            discountedBy(weighedItemPricedPerKiloWithBuy1KiloForHalfPriceDiscount("0.9"), "0.0"),
            discountedBy(weighedItemPricedPerKiloWithBuy1KiloForHalfPriceDiscount("1.1"), "0.30"),
            discountedBy(weighedItemPricedPerKiloWithBuy1KiloForHalfPriceDiscount("2"), "0.60"),
            discountedBy(weighedItemPricedPerKiloWithBuy1KiloForHalfPriceDiscount("5.1"), "1.50")

        );
    }

    private static Arguments discountedBy(final Arguments notDiscountedArguments, final String discount) {
        return Arguments.of(notDiscountedArguments.get()[0] + " with discount",
            new BigDecimal((String) notDiscountedArguments.get()[1]).subtract(
                new BigDecimal(discount))
                .setScale(2, RoundingMode.HALF_UP),
            notDiscountedArguments.get()[2]);

    }
}