package kata.supermarket;

import java.math.BigDecimal;
import java.util.Collection;

public class Buy3ForPriceOf2
    implements Discount {

    private final DiscountType discountType = DiscountType.BUY_1_GET_1_FREE;

    private final DiscountType discountType = DiscountType.BUY_3_FOR_PRICE_OF_2;

    @Override
    public BigDecimal apply(ItemByUnit itemByUnit) {
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal apply(ItemByWeight itemByWeight) {
        return BigDecimal.ZERO;
    }
}
