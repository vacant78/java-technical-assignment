package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Buy1KiloForHalfPrice
    extends Discount {

    private final DiscountType discountType = DiscountType.BUY_1_KILO_FOR_HALF_PRICE;

    @Override
    public BigDecimal apply(ItemByUnit itemByUnit) {
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal apply(ItemByWeight itemByWeight) {

        return
            itemByWeight.weightInKilos().setScale(0, RoundingMode.FLOOR)
                .multiply(itemByWeight.pricePerKilo())
                .multiply(new BigDecimal("0.5"))
                .setScale(2, RoundingMode.HALF_UP)
            ;
    }

    @Override
    protected DiscountType discountType() {
        return discountType;
    }
}
