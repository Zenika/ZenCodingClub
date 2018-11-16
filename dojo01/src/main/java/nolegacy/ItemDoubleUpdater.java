package nolegacy;

import legacy.Item;

public class ItemDoubleUpdater implements ItemUpdater {


    @Override
    public void decreaseQuality(Item item) {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 2);
        }
    }
}
