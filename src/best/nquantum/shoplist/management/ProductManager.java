package best.nquantum.shoplist.management;

import best.nquantum.shoplist.interfaces.IGroceryListModifier;
import best.nquantum.shoplist.products.Product;
import best.nquantum.shoplist.products.ProductNotFoundException;
import best.nquantum.shoplist.util.Handler;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.LinkedList;
import java.util.List;

public final class ProductManager extends Handler<Product> implements IGroceryListModifier<Product> {
    /**
     * Lista produktów
     */
    List<Product> products = new LinkedList<>();

    /**
     * Konstruktor
     */
    public ProductManager() {}

    /**
     * Metoda pozwalająca na zdobycie produktu po jego nazwie.
     * @param argument
     * @return
     */
    public Product getProductByName(final String argument){
        return products.stream().filter(product ->
                product.getProductName().equalsIgnoreCase(argument)).findFirst().get();
    }

    /**
     * Metoda zwracająca wszystkie produkty
     * @return
     */
    public List<Product> getProducts(){
        return products;
    }

    /**
     * Metoda umożliwiająca dodanie produktu do listy.
     * @param productToAdd
     */
    @Override
    public void addProduct(final Product productToAdd){
        this.products.add(productToAdd);
    }

    /**
     * Metoda umożliwiająca usunięcie produktu z listy.
     * @param productToRemove
     */
    @Override
    public void removeProduct(final Product productToRemove){
        this.products.remove(productToRemove);
    }

    /**
     * Setter ilości produktów
     * @param product
     * @param quantity
     */
    @Override
    public void setProductQuantity(final String product, final int quantity) {
        this.getProductByName(product).setProductQuantity(quantity);
    }

    /**
     * Setter ceny produktu
     * @param product
     * @param price
     */
    @Override
    public void setProductPrice(final String product, final double price) {
        this.getProductByName(product).setProductPrice(price);
    }

    /**
     * Setter nazwy produktu
     * @param product
     * @param name
     */
    @Override
    public void setProductName(final String product, final String name) {
        this.getProductByName(product).setProductName(name);
    }

    /**
     * Metoda którą zwrócimy liste produktów zparsowaną i gotową do zapisu.
     * @return
     */
    public List<String> getProductsParsed(){
        List<String> productsList = new ArrayList<>();
        getProducts().forEach((pro -> {
            productsList.add(pro.getProductName() + ":" + pro.getProductQuantity() + ":" + pro.getProductPrice());
        }));
        return productsList;
    }

}
