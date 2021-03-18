package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

public class Buy1Get1Free
    implements Discount {

    @Override
    public BigDecimal calculate(List<Item> items) {
        return BigDecimal.ZERO;
    }
}
