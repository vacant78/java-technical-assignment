package kata.supermarket;

import static java.util.Optional.ofNullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Basket {

    private final Map<Product, Item> itemsByProduct = Maps.newHashMap();
    private final List<Discount> discounts = Lists.newArrayList();

    public Basket() {
    }

    public void add(final Item item) {
        this.itemsByProduct.compute(item.product(), (k, v) ->
            ofNullable(v).map(value -> value.add(item)).orElse(item));
    }

    Collection<Item> items() {
        return Collections.unmodifiableCollection(itemsByProduct.values());
    }

    public BigDecimal total() {
        return new TotalCalculator().calculate();
    }

    public void addDiscounts(final List<Discount> discounts) {
        this.discounts.addAll(discounts);
    }

    private class TotalCalculator {

        private final Collection<Item> itemsByProduct;

        TotalCalculator() {
            this.itemsByProduct = items();
        }

        private BigDecimal subtotal() {
            return itemsByProduct.stream().map(Item::price)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP);
        }

        private BigDecimal discounts() {
            return discounts.stream()
                .map(discount -> discount.calculate(itemsByProduct))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP);
        }

        private BigDecimal calculate() {
            return subtotal().subtract(discounts());
        }
    }
}
