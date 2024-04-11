package tech.hoppr.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Test
    void update_item() {
        GildedRose cut = new GildedRose(getItems());

        cut.updateQuality();

        assertThat(cut.items).extracting("sellIn").containsExactly(9, 1, 4, 0, -1, 14, 9, 4, 2);
        assertThat(cut.items).extracting("quality").containsExactly(19, 1, 6, 80, 80, 21, 50, 50, 5);
    }

    @Test
    void update_item_fifty_times() {
        GildedRose cut = new GildedRose(getItems());

        IntStream.range(0, 50).forEach(i -> cut.updateQuality());

        assertThat(cut.items).extracting("sellIn").containsExactly(-40, -48, -45, 0, -1, -35, -40, -45, -47);
        assertThat(cut.items).extracting("quality").containsExactly(0, 50, 0, 80, 80, 0, 0, 0, 0);
    }

    private static Item[] getItems() {
        return new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};
    }
}