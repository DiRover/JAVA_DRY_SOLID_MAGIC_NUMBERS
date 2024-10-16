package di_rover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Desk implements ShopElement {
    public static final int FILTER_TYPE_ELECTRONICS = 1;
    public static final int FILTER_TYPE_CARS = 2;
    public static final int FILTER_TYPE_ALL = 3;
    private static final List<Integer> filterTypes = new ArrayList<>(Arrays.asList(
            FILTER_TYPE_ELECTRONICS,
            FILTER_TYPE_CARS,
            FILTER_TYPE_ALL
    ));
    private static final List<Product> items = new ArrayList<>(Arrays.asList(
            new Electronics(391, "Laptop", 999.99, ProductType.ELECTRONICS, "red"),
            new Electronics(271, "Smartphone", 699.99, ProductType.ELECTRONICS, "white"),
            new Electronics(330, "Headphones", 199.99, ProductType.ELECTRONICS, "green"),
            new Electronics(153, "Mouse", 15.40, ProductType.ELECTRONICS, "blue"),
            new Electronics(170, "Keyboard", 31.10, ProductType.ELECTRONICS, "yellow"),
            new Electronics(112, "Touchpad", 53.14, ProductType.ELECTRONICS, "black"),
            new Car(14, "BMW", 59999.99, ProductType.CAR, 2024),
            new Car(321, "TOYOTA", 39999.99, ProductType.CAR, 2023),
            new Car(432, "CITROEN", 29999.99, ProductType.CAR, 2024),
            new Car(54, "VOLVO", 79999.99, ProductType.CAR, 2024),
            new Car(6, "VOLKSWAGEN", 49999.99, ProductType.CAR, 2024),
            new Car(10, "SEAT", 19999.99, ProductType.CAR, 2023)
    ));
    private static int currentFilter;
    private static Desk desk;
    public List<Product> filteredItems;

    public static Desk getDesk() {
        if (Objects.isNull(desk)) {
            desk = new Desk();
        }
        return desk;
    }

    public boolean setFilterType(int filterType) {

        boolean isFilterTypeCorrect = filterTypes.contains(filterType);
        if (isFilterTypeCorrect) {
            currentFilter = filterTypes.get(filterType - 1);
            return true;
        }
        return false;
    }

    private List<Product> getItems() {
        switch (currentFilter) {
            case FILTER_TYPE_CARS:
                return items.stream()
                        .filter(item -> item.type.equals(ProductType.CAR))
                        .toList();
            case FILTER_TYPE_ELECTRONICS:
                return items.stream()
                        .filter(item -> item.type.equals(ProductType.ELECTRONICS))
                        .toList();
            default:
                return items;
        }
    }

    public void showItems() {
        filteredItems = getItems();

        for (Product item : filteredItems) {
            System.out.println(item);
        }
    }
}
