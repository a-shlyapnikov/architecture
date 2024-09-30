package builder;

public class Product {
    private String name;
    private int quantity;
    private double price;

    protected Product(ProductBuilder builder) {
        this.name = builder.name;
        this.quantity = builder.quantity;
        this.price = builder.price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
