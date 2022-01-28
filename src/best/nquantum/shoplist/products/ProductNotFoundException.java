package best.nquantum.shoplist.products;

import java.util.function.Supplier;

public final class ProductNotFoundException extends Exception{
    public ProductNotFoundException(final String message) {
        super(message);
    }
}
