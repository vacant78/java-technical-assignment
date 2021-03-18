package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Buy1Get1Free
    extends Discount {

    private final DiscountType discountType = DiscountType.BUY_1_GET_1_FREE;

    @Override
    public BigDecimal apply(ItemByUnit itemByUnit) {
        return
            new BigDecimal(itemByUnit.units() / 2)
                .multiply(itemByUnit.pricePerUnit())
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
