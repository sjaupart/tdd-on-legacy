package tech.hoppr.gildedrose;

public interface ItemKindVisitor<T> {
    T standard();
    T agedBrie();
    T backstage();
    T sulfuras();
}
