package kata.supermarket;


public class Product {

    private final DiscountType applicableDiscount;

    public Product() {
        this(DiscountType.NONE);
    }

    public Product(final DiscountType discountType) {
        this.applicableDiscount = discountType;
    }

    public boolean discountApplies(final DiscountType discountType) {
        return applicableDiscount == discountType;
    }
}
