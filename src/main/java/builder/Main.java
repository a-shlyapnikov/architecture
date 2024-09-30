package builder;

public class Main {
    public static void main(String[] args) {
        Product product = new ProductBuilder()
                .setName("Mouse")
                .setQuantity(5)
                .setPrice(3000)
                .build();
        System.out.println(product);
    }
}
