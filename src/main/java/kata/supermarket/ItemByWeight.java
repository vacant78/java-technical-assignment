package kata.supermarket;

import java.math.BigDecimal;

public class ItemByWeight implements Item {

    private final WeighedProduct product;
    private final BigDecimal weightInKilos;

    ItemByWeight(final WeighedProduct product, final BigDecimal weightInKilos) {
        this.product = product;
        this.weightInKilos = weightInKilos;
    }

    public ItemByWeight addWeight(BigDecimal weightInKilosToAdd) {
        return new ItemByWeight(this.product, this.weightInKilos.add(weightInKilosToAdd));
    }

    public BigDecimal price() {
        return product.pricePerKilo()
            .multiply(weightInKilos)
            .setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
