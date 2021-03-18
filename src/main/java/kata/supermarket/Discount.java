package kata.supermarket;

import java.math.BigDecimal;
import java.util.Collection;

public interface Discount {

    BigDecimal calculate(Collection<Item> items);

    BigDecimal apply(ItemByUnit itemByUnit);

    BigDecimal apply(ItemByWeight itemByWeight);
}
