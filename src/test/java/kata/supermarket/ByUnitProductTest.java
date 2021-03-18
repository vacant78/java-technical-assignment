package kata.supermarket;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ByUnitProductTest {

    @Test
    void singleItemHasExpectedUnitPriceFromProduct() {
        final BigDecimal price = new BigDecimal("2.49");
        assertEquals(price, new ByUnitProduct(price).ofUnits(1).price());
    }

    @Test
    void multipleItemsHaveExpectedPrice() {
        final BigDecimal price = new BigDecimal("2.49");
        assertEquals(price.multiply(new BigDecimal("2")), new ByUnitProduct(price).ofUnits(2).price());
    }
}