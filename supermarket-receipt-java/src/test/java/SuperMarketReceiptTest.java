import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
}
