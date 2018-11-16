package nolegacy;

import legacy.Item;

import java.util.ArrayList;
import java.util.List;

public class Inn_Enhanced {

    private List<Item> items;

    Inn_Enhanced() {
        items = new ArrayList<>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
    }

    List<Item> getItems() {
        return items;
    }


    void updateQuality() {
        for (Item item: items) {
            if("Conjured Mana Cake".equals(item.getName())) {
                new ItemDoubleUpdater().updateQuality(item);
            }
            else {
                new ItemUpdater() {}.updateQuality(item);
            }
        }
    }

}
