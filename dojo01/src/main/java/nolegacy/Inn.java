package nolegacy;

import legacy.Item;

import java.util.ArrayList;
import java.util.List;

public class Inn {

    private List<Item> items;

    public Inn() {
        items = new ArrayList<>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
    }

    public List<Item> getItems() {
        return items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.size(); i++) {

            Item item = items.get(i);
            if (item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            item.setSellIn(item.getSellIn() - 1);
            if (item.getName().equals("Aged Brie")) {
                increaseQuality(item);
                if (item.getSellIn() < 0) {
                    increaseQuality(item);
                }
            } else if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                increaseQuality(item);
                if (item.getSellIn() < 10) increaseQuality(item);
                if (item.getSellIn() < 5) increaseQuality(item);
                if (item.getSellIn() < 0) item.setQuality(0);

            } else {
                decreaseQuality(item);
                if (item.getSellIn() < 0) {
                    decreaseQuality(item);
                }
            }
        }
    }

    private void decreaseQuality(Item item) {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
    }

    private void increaseQuality(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }

}
