package tech.hoppr.gildedrose;

public class ItemUpdater {

    public void update(Item item) {
        ItemKind kind = ItemKind.from(item.name);

        kind.accept(new ItemKindVisitor<Void>() {
            @Override
            public Void standard() {
                decreaseSellIn(item);
                decreaseQuality(item);
                if (item.sellIn < 0) decreaseQuality(item);
                return null;
            }

            @Override
            public Void agedBrie() {
                decreaseSellIn(item);
                increaseQuality(item);
                if (item.sellIn < 0) increaseQuality(item);
                return null;
            }

            @Override
            public Void backstage() {
                decreaseSellIn(item);
                increaseQuality(item);
                if (item.sellIn < 10) increaseQuality(item);
                if (item.sellIn < 5) increaseQuality(item);
                if (item.sellIn < 0) resetQuality(item);
                return null;
            }

            @Override
            public Void sulfuras() {
                return null;
            }
        });
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

    private static void resetQuality(Item item) {
        item.quality = 0;
    }
}
