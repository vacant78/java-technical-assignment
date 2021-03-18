package kata.supermarket;

import com.google.common.base.Preconditions;
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

    @Override
    public Product product() {
        return product;
    }

    @Override
    public Item add(Item item) {
        Preconditions.checkArgument(this.getClass().equals(item.getClass()), "Cannot add incompatible item");
        return this.add((ItemByWeight) item);
    }

    @Override
    public ItemByWeight add(ItemByWeight other) {
        Preconditions.checkArgument(this.product.equals(other.product), "Cannot add incompatible products");
        return this.addWeight(other.weightInKilos);
    }
}
