package di_rover;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cart implements ShopElement {

    private final List<Product> items = new ArrayList<>();

    public boolean addItem(int itemCode, List<Product> itemsFromDesk) {
        Product currentItem = itemsFromDesk.stream()
                .filter(item -> item.code == itemCode)
                .findFirst()
                .orElse(null);

        if (Objects.nonNull(currentItem)) {
            this.items.add(currentItem);
            return true;
        }
        return false;
    }

    @Override
    public void showItems() {
        for (Product item : items) {
            System.out.println(item);
        }
    }
}
