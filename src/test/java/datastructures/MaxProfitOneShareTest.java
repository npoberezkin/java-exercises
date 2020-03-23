package datastructures;

import datastructures.MaxProfitOneShare.MinMaxStartPrice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static datastructures.MaxProfitOneShare.DAYS_RANGE;
import static datastructures.MaxProfitOneShare.findMaxDiff;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxProfitOneShareTest {

    @Test
    public void getRandomPrices_StartBetweenMinAndMax() {
        List<MinMaxStartPrice> prices =
                MaxProfitOneShare.getRandomPrices(DAYS_RANGE);
        long count = prices.stream()
                .filter(p -> p.getMin() > p.getStart() || p.getMax() < p.getStart())
                .count();
        assertEquals(0L, count);
    }

    @Test
    public void findMaxDiff_AscendingPrices_DiffBetweenFirstAndLastDaysProfit() {
        List<MinMaxStartPrice> prices = new ArrayList<>();
        prices.add(new MinMaxStartPrice(0L, 100L, 40L));
        prices.add(new MinMaxStartPrice(0L, 100L, 45L));
        prices.add(new MinMaxStartPrice(0L, 100L, 51L));
        Long maxDiff = findMaxDiff(prices);
        assertEquals(11L, maxDiff);
    }

    @Test
    public void findMaxDiff_DescendingPrices_ZeroProfit() {
        List<MinMaxStartPrice> prices = new ArrayList<>();
        prices.add(new MinMaxStartPrice(0L, 100L, 51L));
        prices.add(new MinMaxStartPrice(0L, 100L, 45L));
        prices.add(new MinMaxStartPrice(0L, 100L, 40L));
        Long maxDiff = findMaxDiff(prices);
        assertEquals(0L, maxDiff);
    }

    @Test
    public void findMaxDiff_MixedPrices1_BiggestDiffProfit() {
        List<MinMaxStartPrice> prices = new ArrayList<>();
        prices.add(new MinMaxStartPrice(0L, 100L, 40L));
        prices.add(new MinMaxStartPrice(0L, 100L, 51L));
        prices.add(new MinMaxStartPrice(0L, 100L, 45L));
        Long maxDiff = findMaxDiff(prices);
        assertEquals(11L, maxDiff);
    }

    @Test
    public void findMaxDiff_MixedPrices2_BiggestDiffProfit() {
        List<MinMaxStartPrice> prices = new ArrayList<>();
        prices.add(new MinMaxStartPrice(0L, 100L, 40L));
        prices.add(new MinMaxStartPrice(0L, 100L, 45L));
        prices.add(new MinMaxStartPrice(0L, 100L, 51L));
        prices.add(new MinMaxStartPrice(0L, 100L, 49L));
        Long maxDiff = findMaxDiff(prices);
        assertEquals(11L, maxDiff);
    }

    @Test
    public void findMaxDiff_MixedPrices3_BiggestDiffProfit() {
        List<MinMaxStartPrice> prices = new ArrayList<>();
        prices.add(new MinMaxStartPrice(0L, 100L, 49L));
        prices.add(new MinMaxStartPrice(0L, 100L, 60L));
        prices.add(new MinMaxStartPrice(0L, 100L, 49L));
        prices.add(new MinMaxStartPrice(0L, 100L, 63L));
        Long maxDiff = findMaxDiff(prices);
        assertEquals(14L, maxDiff);
    }

    @Test
    public void findMaxDiff_MixAfterMax_BiggestDiffProfit() {
        List<MinMaxStartPrice> prices = new ArrayList<>();
        prices.add(new MinMaxStartPrice(0L, 100L, 64L));
        prices.add(new MinMaxStartPrice(0L, 100L, 49L));
        prices.add(new MinMaxStartPrice(0L, 100L, 60L));
        prices.add(new MinMaxStartPrice(0L, 100L, 49L));
        prices.add(new MinMaxStartPrice(0L, 100L, 63L));
        Long maxDiff = findMaxDiff(prices);
        assertEquals(14L, maxDiff);
    }
}
