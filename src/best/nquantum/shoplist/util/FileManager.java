package best.nquantum.shoplist.util;

import best.nquantum.shoplist.main.GroceryList;
import best.nquantum.shoplist.products.Product;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Klasa ta jest enumeratorem, ponieważ nie muszę za każdym razem tworzyć jej instancji oraz mieć łatwy dostęp.
 */
public enum FileManager {
    get;
    final File directory = new File("GroceryLists");

    public void saveGroceryList(final String fileName) throws FileNotFoundException {
        File targetFile = new File(directory + "\\" + fileName + ".list");
        if(!directory.exists()) {
            directory.mkdir();
        }

        PrintWriter writer = new PrintWriter(targetFile);

        GroceryList.getProductManager().getProductsParsed().forEach((pr) -> {
            writer.println(pr);
        });
        writer.println("creationdate:" + System.currentTimeMillis());
        writer.flush();
        writer.close();
    }

    public List<Product> loadGroceryList(final String fileName) throws IOException {
        List<String> lines = new CopyOnWriteArrayList<>();
        List<Product> prods = new ArrayList<>();
        File targetFile = new File(directory + "\\" + fileName + ".list");

        BufferedReader reader = new BufferedReader(new FileReader(targetFile));
        String line = reader.readLine();
        while(line != null) {
            lines.add(line);
            line = reader.readLine();
        }

        lines.forEach((s) -> {
            String[] args = s.split(":");
            if(!s.contains("creationdate")) {
                String name = args[0];
                int quantity = Integer.parseInt(args[1]);
                double price = Double.parseDouble(args[2]);
                prods.add(new Product(name, quantity, price));
            }
        });
        return prods;
    }

    public String getListCreationDate (String listName) throws IOException {
        List<String> lines = new CopyOnWriteArrayList<>();
        String dt = null;
        List<Product> prods = new ArrayList<>();
        File targetFile = new File(directory + "\\" + listName + ".list");
        BufferedReader reader = new BufferedReader(new FileReader(targetFile));
        String line = reader.readLine();
        while(line != null) {
            lines.add(line);
            line = reader.readLine();
        }

        for (String s : lines) {
            String[] args = s.split(":");
            if(s.contains("creation")){
                long millis = Long.parseLong(args[1]);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.ENGLISH);
                Date d = new Date(millis);
                dt = (sdf.format(d));
            }
        }
        return dt;
    }

}
