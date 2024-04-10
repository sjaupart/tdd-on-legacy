package tech.hoppr.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static tech.hoppr.gildedrose.ItemDataBuilder.*;

class ItemUpdaterTest {

    private ItemUpdater cut;

    @BeforeEach
    void setUp() {
        cut = new ItemUpdater();
    }

    public static Stream<Arguments> items() {
        return Stream.of(
                Arguments.of(agedBrie(2, 0), 1, 1),
                Arguments.of(agedBrie(-1, 0), -2, 2),
                Arguments.of(agedBrie(-1, 50), -2, 50),

                Arguments.of(backstage(11, 25), 10, 26),
                Arguments.of(backstage(10, 25), 9, 27),
                Arguments.of(backstage(5, 25), 4, 28),
                Arguments.of(backstage(0, 25), -1, 0),

                Arguments.of(sulfuras(-2, 80), -2, 80),

                // Standard Items
                Arguments.of(standard(2, 50), 1, 49),
                Arguments.of(standard("+5 Dexterity Vest", 2, 50), 1, 49),
                Arguments.of(standard("+5 Dexterity Vest", -1, 50), -2, 48)
        );
    }

    @ParameterizedTest
    @MethodSource("items")
    void items(Item item, int expectedSellIn, int expectedQuality) {
        cut.update(item);

        assertThat(item.sellIn).isEqualTo(expectedSellIn);
        assertThat(item.quality).isEqualTo(expectedQuality);
    }

}