package di_rover;

public class Car extends Product {
    public int year;
    public String brand;

    public Car(int code, String brand, double price, ProductType type, int year) {
        super(code, price, type);

        this.year = year;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "[" + code + "] " + brand + " " + "$" + price + " year: " + year;
    }
}
