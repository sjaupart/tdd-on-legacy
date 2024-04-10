package tech.hoppr.gildedrose;

public enum ItemKind {
    STANDARD(""),
    AGED_BRIE("Aged Brie"),
    BACKSTAGE("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros");

    private final String label;

    ItemKind(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
