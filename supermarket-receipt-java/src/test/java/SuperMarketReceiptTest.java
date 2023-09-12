import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class SuperMarketReceiptTest {
    @Nested
    class BasketTotal {
        @Test
        void empty_basket_should_cost_nothing() {
            var basket = new Basket();

            assertThat(basket.total()).describedAs("basket total")
                    .isEqualTo(Amount.ZERO);
        }

        @Test
        void basket_with_one_product_should_cost_the_product_price() {
            var apple = new Product("apple", new Amount(20));
            var basket = new Basket(apple);

            assertThat(basket.total()).describedAs("basket total")
                    .isEqualTo(new Amount(20));
        }

        @Test
        void basket_with_two_identical_products_should_cost_twice_the_product_price() {
            var apple = new Product("apple", new Amount(20));
            var basket = new Basket(apple, apple);

            assertThat(basket.total()).describedAs("basket total")
                    .isEqualTo(new Amount(2 * 20));
        }

        @Test
        void basket_with_two_different_products_should_cost_the_sum_of_product_prices() {
            var apple = new Product("apple", new Amount(20));
            var orange = new Product("orange", new Amount(17));
            var basket = new Basket(apple, orange);

            assertThat(basket.total()).describedAs("basket total")
                    .isEqualTo(new Amount(20 + 17));
        }
    }

    @Nested
    class PrintTheReceipt {

        @Disabled("work in progress")
        @Test
        void simple_basket_with_several_products_without_discounts() {
            var apple = new Product("apple", new Amount(20));
            var orange = new Product("orange", new Amount(17));
            var basket = new Basket(apple, apple, orange);

            assertThat(basket.receiptString()).describedAs("receipt")
                    .isEqualTo("""
                           Product            #     EUR      sub-total
                           ------------------ ----- -------- ---------
                           apple              2     0.20     0.40   
                           orange             1     0.17     0.17
                           ------------------ ----- -------- ---------
                           TOTAL                    EUR      0.57
                           """);
        }


        @Test
        void simple_basket_with_one_product_without_discounts__example1() {
            var apple = new Product("apple", new Amount(20));
            var basket = new Basket(apple);

            assertThat(basket.receiptString()).describedAs("receipt")
                    .isEqualTo("""
                           Product            #     EUR      sub-total
                           ------------------ ----- -------- ---------
                           apple              1     0.20     0.20   
                           ------------------ ----- -------- ---------
                           TOTAL                    EUR      0.20
                           """);
        }

        @Test
        void simple_basket_with_one_product_without_discounts__example_2() {
            var orange = new Product("orange", new Amount(17));
            var basket = new Basket(orange);

            assertThat(basket.receiptString()).describedAs("receipt")
                    .isEqualTo("""
                           Product            #     EUR      sub-total
                           ------------------ ----- -------- ---------
                           orange             1     0.17     0.17   
                           ------------------ ----- -------- ---------
                           TOTAL                    EUR      0.17
                           """);
        }

        @ParameterizedTest
        @CsvSource(value = {
                "apple, 20",
                "orange, 17",
        })
        void simple_basket_with_one_product_without_discounts(String description, int cents) {
            var basket = new Basket(new Product(description, new Amount(cents)));

            assertThat(basket.receiptString()).describedAs("receipt")
                    .isEqualTo("""
                           Product            #     EUR      sub-total
                           ------------------ ----- -------- ---------
                           %1$-18s 1     0.%2$-6d 0.%2$d   
                           ------------------ ----- -------- ---------
                           TOTAL                    EUR      0.%3$d
                           """.formatted(description, cents, basket.total().cents()));
        }

        @Test
        void simple_basket_with_several_product_without_discounts__example_1() {
            var orange = new Product("orange", new Amount(17));
            var basket = new Basket(orange, orange);

            assertThat(basket.receiptString()).describedAs("receipt")
                    .isEqualTo("""
                           Product            #     EUR      sub-total
                           ------------------ ----- -------- ---------
                           orange             2     0.17     0.34   
                           ------------------ ----- -------- ---------
                           TOTAL                    EUR      0.34
                           """);
        }
    }
}
