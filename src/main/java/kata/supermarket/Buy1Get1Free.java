package kata.supermarket;

import java.math.BigDecimal;
import java.util.Collection;

public class Buy1Get1Free
    implements Discount {

    @Override
    public BigDecimal calculate(Collection<Item> items) {
        return BigDecimal.ZERO;
    }
}
