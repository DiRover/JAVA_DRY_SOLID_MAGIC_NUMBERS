package di_rover;

public class Electronics extends Product {
    public String deviceType;
    public String color;

    public Electronics(int code, String deviceType, double price, ProductType type, String color) {
        super(code, price, type);
        this.deviceType = deviceType;
        this.color = color;
    }

    @Override
    public String toString() {
        return "[" + code + "] " + deviceType + " " + "$" + price + " color: " + color;
    }
}
