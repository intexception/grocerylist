package best.nquantum.shoplist.products;

public class Product {
    /**
     * Parametry produktu
     */
    private String productName;
    private int productQuantity;
    private double productPrice;

    /**
     * Konstruktor dla dużej ilości produktów
     * @param productName
     * @param productQuantity
     * @param productPrice
     */
    public Product(String productName, int productQuantity, double productPrice) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    /**
     * Konstruktor dla jednego produktu
     * @param productName
     * @param productPrice
     */
    public Product(String productName, double productPrice) {
        this.productName = productName;
        this.productQuantity = 1;
        this.productPrice = productPrice;
    }

    /**
     * Getter dla nazwy produktu
     * @return
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Setter nazwy produktu
     * @param productName
     * @return
     */
    public Product setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    /**
     * Getter dla ilości produktów
     * @return
     */
    public int getProductQuantity() {
        return productQuantity;
    }

    /**
     * Setter dla ilości produktów
     * @param productQuantity
     * @return
     */
    public Product setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
        return this;
    }

    /**
     * Getter dla ceny produktu
     * @return
     */
    public double getProductPrice() {
        return productPrice;
    }

    /**
     * Setter dla nazwy produktu
     * @param productPrice
     * @return
     */
    public Product setProductPrice(double productPrice) {
        this.productPrice = productPrice;
        return this;
    }
}
