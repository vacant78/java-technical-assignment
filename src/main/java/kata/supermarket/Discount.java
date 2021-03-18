package kata.supermarket;

import java.math.BigDecimal;
import java.util.Collection;

public abstract class Discount {

    protected abstract DiscountType discountType();

    public BigDecimal calculate(Collection<Item> items) {
        final BigDecimal totalDiscount = items.stream()
            .filter(item -> item.product().discountApplies(discountType()))
            .map(item -> item.applyDiscount(this))
            .reduce(BigDecimal::add)
            .orElse(BigDecimal.ZERO);

        return totalDiscount;
    }

    public BigDecimal apply(ItemByUnit itemByUnit) {
        return BigDecimal.ZERO;
    }

    public BigDecimal apply(ItemByWeight itemByWeight) {
        return BigDecimal.ZERO;
    }

}

