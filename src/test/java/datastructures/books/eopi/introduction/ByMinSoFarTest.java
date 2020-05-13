package datastructures.books.eopi.introduction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static datastructures.books.eopi.introduction.MaxProfitFinder.findMaxProfitByMinSoFar;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ByMinSoFarTest {

    @Test
    public void byMinSoFar_EmptyArray_Zero() {
        List<Long> prices = new ArrayList<>();
        Long maxDiff = findMaxProfitByMinSoFar(prices);
        assertEquals(0L, maxDiff);
    }

    @Test
    public void byMinSoFar_NullArray_RuntimeException() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            List<Long> prices = null;
            Long maxDiff = findMaxProfitByMinSoFar(prices);
            assertEquals(0L, maxDiff);
        });
    }

    @Test
    public void byMinSoFar_OneElemArray_Zero() {
        List<Long> prices = new ArrayList<>();
        prices.add(1L);
        Long maxDiff = findMaxProfitByMinSoFar(prices);
        assertEquals(0L, maxDiff);
    }

    @Test
    public void byMinSoFar_AscendingPrices_DiffBetweenFirstAndLastDaysProfit() {
        List<Long> prices = new ArrayList<>();
        prices.add(1L);
        prices.add(3L);
        prices.add(5L);
        Long maxDiff = findMaxProfitByMinSoFar(prices);
        assertEquals(4L, maxDiff);
    }

    @Test
    public void byMinSoFar_DescendingPrices_ZeroProfit() {
        List<Long> prices = new ArrayList<>();
        prices.add(5L);
        prices.add(3L);
        prices.add(1L);
        Long maxDiff = findMaxProfitByMinSoFar(prices);
        assertEquals(0L, maxDiff);
    }

    @Test
    public void byMinSoFar_MixedPrices1_BiggestDiffProfit() {
        List<Long> prices = new ArrayList<>();
        prices.add(1L);
        prices.add(5L);
        prices.add(3L);
        Long maxDiff = findMaxProfitByMinSoFar(prices);
        assertEquals(4L, maxDiff);
    }

    @Test
    public void byMinSoFar_MixedPrices2_BiggestDiffProfit() {
        List<Long> prices = new ArrayList<>();
        prices.add(1L);
        prices.add(3L);
        prices.add(1L);
        prices.add(4L);
        Long maxDiff = findMaxProfitByMinSoFar(prices);
        assertEquals(3L, maxDiff);
    }

    @Test
    public void byMinSoFar_MinAfterMax_BiggestDiffProfit() {
        List<Long> prices = new ArrayList<>();
        prices.add(10L);
        prices.add(1L);
        prices.add(6L);
        prices.add(1L);
        prices.add(8L);
        Long maxDiff = findMaxProfitByMinSoFar(prices);
        assertEquals(7L, maxDiff);
    }
}
