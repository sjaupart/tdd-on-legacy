package tech.hoppr.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.IntStream;

class GildedRoseTest {

    GildedRose cut;

    private PrintStream standardOutput;
    ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        cut = new GildedRose(getItems());

        standardOutput = System.out;
        outputStream = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOutput);
    }

    @Test
    void updateOnThirtyDays() {
        IntStream.range(0, 30).forEach(i -> {
            cut.updateQuality();
            printItems(cut.items);
        });

        Approvals.verify(outputStream.toString());
    }

    private static void printItems(Item[] items) {
        Arrays.stream(items).forEach(System.out::println);
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