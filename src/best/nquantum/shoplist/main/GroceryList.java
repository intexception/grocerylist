package best.nquantum.shoplist.main;

import best.nquantum.shoplist.products.Product;
import best.nquantum.shoplist.management.ProductManager;
import best.nquantum.shoplist.util.Colors;
import best.nquantum.shoplist.util.FileManager;
import best.nquantum.shoplist.util.StringUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class GroceryList {
    static ProductManager productManager;
    static String listNameIn;
    public static void initializeApplication() throws IOException {
        productManager = new ProductManager();
        String lista = "██╗     ██╗███████╗████████╗ █████╗     ███████╗ █████╗ ██╗  ██╗██╗   ██╗██████╗  ██████╗ ██╗    ██╗\n" +
                "██║     ██║██╔════╝╚══██╔══╝██╔══██╗    ╚══███╔╝██╔══██╗██║ ██╔╝██║   ██║██╔══██╗██╔═══██╗██║    ██║\n" +
                "██║     ██║███████╗   ██║   ███████║      ███╔╝ ███████║█████╔╝ ██║   ██║██████╔╝██║   ██║██║ █╗ ██║\n" +
                "██║     ██║╚════██║   ██║   ██╔══██║     ███╔╝  ██╔══██║██╔═██╗ ██║   ██║██╔═══╝ ██║   ██║██║███╗██║\n" +
                "███████╗██║███████║   ██║   ██║  ██║    ███████╗██║  ██║██║  ██╗╚██████╔╝██║     ╚██████╔╝╚███╔███╔╝\n" +
                "╚══════╝╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝    ╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝ ╚═╝      ╚═════╝  ╚══╝╚══╝ \n" +
                "                                                                                                    ";


        System.out.println(Colors.RED_BOLD_BRIGHT + lista + Colors.RESET);
        System.out.println("Wybierz opcje:\n");
        printPrefix(1, "Stworz liste");
        printPrefix(2, "Zaladuj liste");
        printPrefix(3, "Zakoncz");

        Scanner scanner = new Scanner(System.in);
        int opcja = Integer.parseInt(scanner.next());

        switch (opcja){
            case 1: {
                Scanner scan2 = new Scanner(System.in);
                System.out.println("Podaj nazwe twojej listy");
                listNameIn = scan2.nextLine();
                createNewProductFromInput();

                /*
                FileManager.get.loadGroceryList(listNameIn).forEach((pr) -> {
                    System.out.println(pr.getProductName() + ", Ilosc: " + pr.getProductQuantity() + ", Cena: " + pr.getProductPrice() + "PLN");
                });

                 */
                break;
            }
            case 2: {
                double cenaFinalna = 0;
                int iloscproduktow = 0;
                DecimalFormat roundTo2Places = new DecimalFormat("#.##");
                Scanner scanLoad = new Scanner(System.in);
                String listName = scanLoad.nextLine();

                FileManager.get.loadGroceryList(listName).forEach((l) -> {productManager.addProduct(l);});

                for (Product product : productManager.getProducts()) {
                    iloscproduktow ++;
                    cenaFinalna += (product.getProductPrice() * product.getProductQuantity());
                    System.out.println(Colors.RED_BOLD_BRIGHT + iloscproduktow + "." + Colors.RESET + " " + StringUtils.capitalizeOnlyFirst(product.getProductName()) + ", Ilosc: " + Colors.RED_BOLD_BRIGHT + product.getProductQuantity() + Colors.RESET + ", Cena: " + Colors.RED_BOLD_BRIGHT + product.getProductPrice() + Colors.RESET + " PLN");
                }
                System.out.println("Stworzono: " + Colors.RED_BOLD_BRIGHT + FileManager.get.getListCreationDate(listName) + Colors.RESET);
                System.out.println("Razem: " + Colors.RED_BOLD_BRIGHT + roundTo2Places.format(cenaFinalna));

                break;
            }
            case 3: {
                break;
            }
        }

        /*

        productManager.addProduct(new Product("Pomidory",22,10.59));
        productManager.addProduct(new Product("Truskawki",2,2.19));
        productManager.addProduct(new Product("Jablka", 2, 2.59));

        FileManager.get.saveGroceryList("lista_1");
        List<Product> produkty = FileManager.get.loadGroceryList("lista_1");
        produkty.forEach((pr) -> {
            productManager.addProduct(pr);
        });
        productManager.getProducts().forEach(product -> {
            System.out.println(product.getProductName() + ", Ilosc: " + product.getProductQuantity() + ", Cena: " + product.getProductPrice() + "PLN");
        });

         */
    }

    static void printPrefix(int l, String info){
        System.out.println(Colors.WHITE + "[" + Colors.RED_BRIGHT + l + Colors.WHITE + "] " + Colors.RESET + info);
    }

    static void createNewProductList(){

    }

    static void createNewProductFromInput() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String name;
        int quantity;
        double price;
        System.out.println("Wprowadz nazwe dla Twojego produktu");
        String prodNameIn = scanner.nextLine();
        name = prodNameIn;
        System.out.println("Wprowadz ilość tego produktu");
        String prodQuantityIn = scanner.nextLine();
        quantity = Integer.parseInt(prodQuantityIn);
        System.out.println("Wprowadz cene tego produktu (np. 1.99)");
        String prodPriceIn = scanner.nextLine();
        price = Double.parseDouble(prodPriceIn);
        getProductManager().addProduct(new Product(name,quantity,price));
        prompt();
    }

    static void prompt() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        printPrefix(1, "Dodaj kolejny produkt");
        printPrefix(2, "Zapisz");
        int o = Integer.parseInt(scanner.nextLine());
        switch (o){
            case 1:
                createNewProductFromInput();
                break;
            case 2:
                FileManager.get.saveGroceryList(listNameIn);
                break;
        }
    }

    public static ProductManager getProductManager() {return productManager;}
}
