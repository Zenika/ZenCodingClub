package nolegacy;

import legacy.Item;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Inn_EnhancedTest {

    @Test
    public void one_update_conjured_items() {
        Inn_Enhanced inn = new Inn_Enhanced();
        inn.updateQuality();
        List<Item> items = inn.getItems();

        assertThat(items).extracting("name").containsExactly("+5 Dexterity Vest", "Aged Brie", "Elixir of the Mongoose", "Sulfuras, Hand of Ragnaros", "Backstage passes to a TAFKAL80ETC concert", "Conjured Mana Cake");
        assertThat(items).extracting("sellIn").containsExactly(9, 1, 4, 0, 14, 2);
        assertThat(items).extracting("quality").containsExactly(19, 1, 6, 80, 21, 4);
    }

}
