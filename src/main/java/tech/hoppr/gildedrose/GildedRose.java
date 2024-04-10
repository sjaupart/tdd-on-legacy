package tech.hoppr.gildedrose;

public class GildedRose {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            String name = item.name;

            if (name.equals(SULFURAS)) {
                continue;
            }

            decreaseSellIn(item);

            if (name.equals(AGED_BRIE)) {
                increaseQuality(item);
                if (item.sellIn < 0) increaseQuality(item);
            } else if (name.equals(BACKSTAGE)) {
                increaseQuality(item);
                if (item.sellIn < 10) increaseQuality(item);
                if (item.sellIn < 5) increaseQuality(item);
                if (item.sellIn < 0) resetQuality(item);
            } else {
                decreaseQuality(item);
                if (item.sellIn < 0) decreaseQuality(item);
            }
        }
    }

    private static void resetQuality(Item item) {
        item.quality = 0;
    }

    private static void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private static void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private static void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
