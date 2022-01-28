package best.nquantum.shoplist.util;

public class StringUtils {
    public static String capitalizeOnlyFirst(String s0){
        return s0.substring(0,1).toUpperCase() + s0.substring(1).toLowerCase();
    }
}
