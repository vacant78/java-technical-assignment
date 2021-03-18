package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;

public class Buy1Get1Free
    implements Discount {

    private final DiscountType discountType = DiscountType.BUY_1_GET_1_FREE;

    @Override
    public BigDecimal calculate(Collection<Item> items) {
        final BigDecimal totalDiscount = items.stream()
            .filter(item -> item.product().discountApplies(discountType))
            .map(item -> item.applyDiscount(this))
            .reduce(BigDecimal::add)
            .orElse(BigDecimal.ZERO);

        return totalDiscount;

    }

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
}
