package kata.supermarket;

import java.math.BigDecimal;

public class ItemByUnit implements Item {

    private final int units;
    private final Product product;

    ItemByUnit(final Product product, final int units) {
        this.product = product;
        this.units = units;
    }

    public ItemByUnit addUnits(int unitsToAdd) {
        return new ItemByUnit(this.product, this.units + unitsToAdd);
    }

    public BigDecimal price() {
        return product.pricePerUnit()
            .multiply(new BigDecimal(units))
            .setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
