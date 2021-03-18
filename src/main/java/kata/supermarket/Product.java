package kata.supermarket;

import com.google.common.base.Preconditions;
import java.math.BigDecimal;

public class Product {

    private final BigDecimal pricePerUnit;

    public Product(final BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item ofUnits(int units) {
        Preconditions.checkArgument(units > 0, "Cannot assign 0 units");
        return new ItemByUnit(this, units);
    }
}
