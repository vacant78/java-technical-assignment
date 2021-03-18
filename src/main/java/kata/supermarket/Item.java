package kata.supermarket;

import java.math.BigDecimal;

public interface Item {

    BigDecimal price();

    Product product();

    Item add(Item item);

    default ItemByUnit add(ItemByUnit other) {
        throw new UnsupportedOperationException("operation needs to be overriden in implementing class");
    }

    default ItemByWeight add(ItemByWeight other) {
        throw new UnsupportedOperationException("operation needs to be overriden in implementing class");
    }

    BigDecimal applyDiscount(Discount discount);
}
