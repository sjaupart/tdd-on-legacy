package tech.hoppr.gildedrose;

import java.util.stream.Stream;

public enum ItemKind {
    STANDARD("") {
        @Override
        public <T> T accept(ItemKindVisitor<T> visitor) {
            return visitor.standard();
        }
    },
    AGED_BRIE("Aged Brie") {
        @Override
        public <T> T accept(ItemKindVisitor<T> visitor) {
            return visitor.agedBrie();
        }
    },
    BACKSTAGE("Backstage passes to a TAFKAL80ETC concert") {
        @Override
        public <T> T accept(ItemKindVisitor<T> visitor) {
            return visitor.backstage();
        }
    },
    SULFURAS("Sulfuras, Hand of Ragnaros") {
        @Override
        public <T> T accept(ItemKindVisitor<T> visitor) {
            return visitor.sulfuras();
        }
    },
    ;

    private final String label;

    ItemKind(String label) {
        this.label = label;
    }

    public static ItemKind from(String name) {
        return Stream.of(values())
                .filter(value -> value.label.equals(name))
                .findFirst()
                .orElse(STANDARD);
    }

    public String label() {
        return label;
    }

    public abstract <T> T accept(ItemKindVisitor<T> visitor);
}
