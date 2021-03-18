package kata.supermarket;

import static kata.supermarket.ProductsAndItemsUtils.aPintOfMilk;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ItemByUnitTest {

    @Test
    void shouldAddCompatibleProductsAndItems() {
        final Item twoPintsOfMilk = aPintOfMilk().add(aPintOfMilk());
        assertEquals(new BigDecimal("0.98"), twoPintsOfMilk.price(), "expected 2x single pint of milk price");
    }

}