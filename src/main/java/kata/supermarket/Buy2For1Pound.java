package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Buy2For1Pound
    extends Discount {

    private final DiscountType discountType = DiscountType.BUY_2_FOR_1_POUND;

    @Override
    public BigDecimal apply(ItemByUnit itemByUnit) {
        return
            new BigDecimal(itemByUnit.units() / 2)
                .multiply(itemByUnit.pricePerUnit().multiply(new BigDecimal(2)).subtract(BigDecimal.ONE))
                .setScale(2, RoundingMode.HALF_UP)
            ;
    }

    @Override
    public BigDecimal apply(ItemByWeight itemByWeight) {
        return BigDecimal.ZERO;
    }

    @Override
    protected DiscountType discountType() {
        return discountType;
    }
}
