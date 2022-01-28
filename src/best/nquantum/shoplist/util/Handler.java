package best.nquantum.shoplist.util;

import java.util.List;

public class Handler<T> {
    protected List<T> elements;

    public Handler() {
        this.elements = null;
    }

    public List<T> getElements() {
        return this.elements;
    }
}
