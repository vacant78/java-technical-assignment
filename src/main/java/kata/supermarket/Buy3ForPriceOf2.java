package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Buy3ForPriceOf2
    extends Discount {

    private final DiscountType discountType = DiscountType.BUY_3_FOR_PRICE_OF_2;

    @Override
    public BigDecimal apply(ItemByUnit itemByUnit) {
        return
            new BigDecimal(itemByUnit.units() / 3)
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
