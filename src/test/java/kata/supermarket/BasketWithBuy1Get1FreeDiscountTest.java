package kata.supermarket;

import static kata.supermarket.ProductsAndItemsUtils.aSingleItemPricedPerUnit;
import static kata.supermarket.ProductsAndItemsUtils.noItems;
import static kata.supermarket.ProductsAndItemsUtils.twoItemsPricedPerUnitWithBuy1Get1FreeDiscount;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BasketWithBuy1Get1FreeDiscountTest {

    @DisplayName("basket with Buy1Get1Free discount provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValue(String description, BigDecimal expectedTotal, Iterable<Item> items) {
        final Basket basket = new Basket();
        basket.addDiscounts(ImmutableList.of(new Buy1Get1Free()));
        items.forEach(basket::add);
        assertEquals(expectedTotal, basket.total());
    }

    static Stream<Arguments> basketProvidesTotalValue() {
        return Stream.of(
            discountedBy(noItems(), "0.0"),
            discountedBy(aSingleItemPricedPerUnit(), "0.0"),
            discountedBy(twoItemsPricedPerUnitWithBuy1Get1FreeDiscount(), "0.49")

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