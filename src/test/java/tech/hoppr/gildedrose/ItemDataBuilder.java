package tech.hoppr.gildedrose;

import static tech.hoppr.gildedrose.ItemKind.*;

public class ItemDataBuilder {

    public static Item agedBrie(int sellIn, int quality) {
        return new Item(AGED_BRIE.label(), sellIn, quality);
    }

    public static Item backstage(int sellIn, int quality) {
        return new Item(BACKSTAGE.label(), sellIn, quality);
    }

    public static Item sulfuras(int sellIn, int quality) {
        return new Item(SULFURAS.label(), sellIn, quality);
    }

    public static Item standard(int sellIn, int quality) {
        return new Item(STANDARD.label(), sellIn, quality);
    }

    public static Item standard(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }
}
