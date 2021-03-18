package kata.supermarket;

import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import java.util.Objects;

public class ByUnitProduct extends Product {

    private final BigDecimal pricePerUnit;

    public ByUnitProduct(final BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public ByUnitProduct(final BigDecimal pricePerUnit, DiscountType discountType) {
        super(discountType);
        this.pricePerUnit = pricePerUnit;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item ofUnits(int units) {
        Preconditions.checkArgument(units > 0, "Cannot assign 0 units");
        return new ItemByUnit(this, units);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final ByUnitProduct that = (ByUnitProduct) o;

        return Objects.equals(pricePerUnit, that.pricePerUnit);
    }

    @Override
    public int hashCode() {
        return pricePerUnit.hashCode();
    }
}
