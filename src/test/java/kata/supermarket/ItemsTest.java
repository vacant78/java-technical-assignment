package kata.supermarket;

import static kata.supermarket.ProductsAndItemsUtils.aPackOfDigestives;
import static kata.supermarket.ProductsAndItemsUtils.aPintOfMilk;
import static kata.supermarket.ProductsAndItemsUtils.twoFiftyGramsOfAmericanSweets;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ItemsTest {

    @Test
    void shouldThrowWhenAddingIncompatibleProductsWithinCompatibleItems() {
        assertThrows(IllegalArgumentException.class,
            () -> aPintOfMilk().add(aPackOfDigestives()));
    }

    @Test
    void shouldThrowWhenAddingIncompatibleItems() {
        assertThrows(IllegalArgumentException.class,
            () -> aPintOfMilk().add(twoFiftyGramsOfAmericanSweets()));
    }

}