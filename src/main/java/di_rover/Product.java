package di_rover;

public class Product {
    public String id;
    public int code;
    public double price;
    public ProductType type;

    public Product(int code, double price, ProductType type) {
        this.id = IdGenerator.generateRandomId();
        this.code = code;
        this.price = price;
        this.type = type;
    }
}
