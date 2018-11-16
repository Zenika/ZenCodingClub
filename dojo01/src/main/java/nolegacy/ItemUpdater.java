package nolegacy;

import legacy.Item;

public interface ItemUpdater {

    default void updateQuality(Item item) {
        if ("Sulfuras, Hand of Ragnaros".equals(item.getName())) {
            return;
        }

        item.setSellIn(item.getSellIn() - 1);

        if ("Aged Brie".equals(item.getName())) {
            increaseQuality(item);

            if (item.getSellIn() < 0) increaseQuality(item);
        } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
            increaseQuality(item);

            if (item.getSellIn() < 10) increaseQuality(item);
            if (item.getSellIn() < 5) increaseQuality(item);
            if (item.getSellIn() < 0) item.setQuality(0);
        } else {
            decreaseQuality(item);

            if (item.getSellIn() < 0) decreaseQuality(item);
        }
    }

    default void decreaseQuality(Item item) {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
    }

    default void increaseQuality(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }
}
