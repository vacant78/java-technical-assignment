package kata.supermarket;

import static kata.supermarket.ProductsAndItemsUtils.aSingleItemPricedPerUnit;
import static kata.supermarket.ProductsAndItemsUtils.multipleItemsPricedPerUnitWithBuy3Get2FreeDiscount;
import static kata.supermarket.ProductsAndItemsUtils.noItems;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BasketWithBuy3ForPriceOf2DiscountTest {

    @DisplayName("basket with Buy3ForPriceOf2 discount provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValue(String description, BigDecimal expectedTotal, Iterable<Item> items) {
        final Basket basket = new Basket();
        basket.addDiscounts(ImmutableList.of(new Buy3ForPriceOf2()));
        items.forEach(basket::add);
        assertEquals(expectedTotal, basket.total());
    }

    static Stream<Arguments> basketProvidesTotalValue() {
        return Stream.of(
            discountedBy(noItems(), "0.0"),
            discountedBy(aSingleItemPricedPerUnit(), "0.0"),
            discountedBy(multipleItemsPricedPerUnitWithBuy3Get2FreeDiscount(3), "0.49"),
            discountedBy(multipleItemsPricedPerUnitWithBuy3Get2FreeDiscount(4), "0.49"),
            discountedBy(multipleItemsPricedPerUnitWithBuy3Get2FreeDiscount(5), "0.49"),
            discountedBy(multipleItemsPricedPerUnitWithBuy3Get2FreeDiscount(6), "0.98")

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