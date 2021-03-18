package kata.supermarket;

import java.math.BigDecimal;
import java.util.Objects;


public class WeighedProduct implements Product {

    private final BigDecimal pricePerKilo;

    public WeighedProduct(final BigDecimal pricePerKilo) {
        this.pricePerKilo = pricePerKilo;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final WeighedProduct that = (WeighedProduct) o;

        return Objects.equals(pricePerKilo, that.pricePerKilo);
    }

    @Override
    public int hashCode() {
        return pricePerKilo != null ? pricePerKilo.hashCode() : 0;
    }
}
