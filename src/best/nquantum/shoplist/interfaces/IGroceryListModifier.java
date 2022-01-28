package best.nquantum.shoplist.interfaces;

import best.nquantum.shoplist.products.Product;

/**
 * Interfejs do modyfikacji produktów
 * @param <T>
 */
public interface IGroceryListModifier<T> {
    void addProduct(final T productToAdd);
    void removeProduct(final T productToRemove);
    void setProductQuantity(final String product, final int quantity);
    void setProductPrice(final String product, final double price);
    void setProductName(final String product, final String name);
}
