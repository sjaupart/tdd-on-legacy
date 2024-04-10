package tech.hoppr.gildedrose;

public class GildedRose {

    ItemUpdater updater;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
        this.updater = new ItemUpdater();
    }

    public void updateQuality() {
        for (Item item : items) {
            updater.update(item);
        }
    }

}
