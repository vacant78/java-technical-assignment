package kata.supermarket;

import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemByUnit implements Item {

    private final int units;
    private final ByUnitProduct product;

    ItemByUnit(final ByUnitProduct product, final int units) {
        this.product = product;
        this.units = units;
    }

    public ItemByUnit addUnits(int unitsToAdd) {
        return new ItemByUnit(this.product, this.units + unitsToAdd);
    }

    public BigDecimal price() {
        return product.pricePerUnit()
            .multiply(new BigDecimal(units))
            .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal pricePerUnit() {
        return product.pricePerUnit();
    }

    public int units() {
        return units;
    }

    @Override
    public Product product() {
        return product;
    }

    @Override
    public Item add(Item item) {
        Preconditions.checkArgument(this.getClass().equals(item.getClass()), "Cannot add incompatible item");
        return this.add((ItemByUnit) item);
    }

    @Override
    public ItemByUnit add(ItemByUnit other) {
        Preconditions.checkArgument(this.product.equals(other.product), "Cannot add incompatible products");
        return this.addUnits(other.units);
    }

    @Override
    public BigDecimal applyDiscount(Discount discount) {
        return discount.apply(this);
    }
}
