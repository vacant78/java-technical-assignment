package kata.supermarket;

import static kata.supermarket.ProductsAndItemsUtils.fourHundredGramsOfAmericanSweets;
import static kata.supermarket.ProductsAndItemsUtils.twoFiftyGramsOfAmericanSweets;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ItemByWeightTest {

    @Test
    void shouldAddCompatibleProductsAndItems() {
        final Item twoPintsOfMilk = twoFiftyGramsOfAmericanSweets().add(fourHundredGramsOfAmericanSweets());
        assertEquals(new BigDecimal("3.24"), twoPintsOfMilk.price(), "expected 250g + 400g times price");
    }
}