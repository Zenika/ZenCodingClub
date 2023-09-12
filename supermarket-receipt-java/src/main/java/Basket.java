import java.util.Arrays;
import java.util.List;

public class Basket {
    private final List<Product> products;

    public Basket(Product... products) {
        this.products = List.of(products);
    }

    public Amount total() {
        var total = products.stream()
                .map(Product::price)
                .mapToInt(Amount::cents)
                .sum();
        return new Amount(total);
    }
}
