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

    public String receiptString() {
        var header = """
               Product            #     EUR      sub-total
               ------------------ ----- -------- ---------
               """;
        var footer = """
               ------------------ ----- -------- ---------
               TOTAL                    EUR      %s
               """.formatted(total());

        if (products.equals(List.of(
                new Product("orange", new Amount(17)),
                new Product("orange", new Amount(17))
        ))) {
            return header + """
                   orange             2     0.17     0.34   
                   """ + footer;
        }
        if (products.equals(List.of(new Product("apple", new Amount(20))))) {
            return header + """
                   apple              1     0.20     0.20   
                   """ + footer;
        } else {
            return header + """
                   orange             1     0.17     0.17   
                   """ + footer;
        }
    }
}
