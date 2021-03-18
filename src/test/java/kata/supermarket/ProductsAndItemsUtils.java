package kata.supermarket;

import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.params.provider.Arguments;

class ProductsAndItemsUtils {


    static Arguments aSingleItemPricedByWeight() {
        return Arguments.of("a single weighed item", "1.25", Collections.singleton(twoFiftyGramsOfAmericanSweets()));
    }

    static Arguments multipleItemsPricedByWeight() {
        return Arguments.of("multiple weighed items", "1.85",
            Arrays.asList(twoFiftyGramsOfAmericanSweets(), twoHundredGramsOfPickAndMix())
        );
    }

    static Arguments multipleItemsPricedPerUnit() {
        return Arguments.of("multiple items priced per unit", "2.04",
            Arrays.asList(aPackOfDigestives(), aPintOfMilk()));
    }

    static Arguments aSingleItemPricedPerUnit() {
        return Arguments.of("a single item priced per unit", "0.49", Collections.singleton(aPintOfMilk()));
    }

    static Arguments twoItemsPricedPerUnit() {
        return Arguments.of("two items priced per unit", "0.98", ImmutableList.of(aPintOfMilk(), aPintOfMilk()));
    }

    static Arguments noItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList());
    }

    static Item aPintOfMilk() {
        return new Product(new BigDecimal("0.49")).ofUnits(1);
    }

    static Item aPackOfDigestives() {
        return new Product(new BigDecimal("1.55")).ofUnits(1);
    }

    static WeighedProduct aKiloOfAmericanSweets() {
        return new WeighedProduct(new BigDecimal("4.99"));
    }

    static Item twoFiftyGramsOfAmericanSweets() {
        return aKiloOfAmericanSweets().weighing(new BigDecimal(".25"));
    }

    static WeighedProduct aKiloOfPickAndMix() {
        return new WeighedProduct(new BigDecimal("2.99"));
    }

    static Item twoHundredGramsOfPickAndMix() {
        return aKiloOfPickAndMix().weighing(new BigDecimal(".2"));
    }
}