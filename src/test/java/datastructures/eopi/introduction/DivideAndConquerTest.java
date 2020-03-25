package datastructures.eopi.introduction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static datastructures.eopi.introduction.MaxProfitFinder.findMaxProfitDivideAndConquer;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivideAndConquerTest {

    @Test
    public void divideAndConquer_EmptyArray_Zero() {
        List<Long> prices = new ArrayList<>();
        Long maxDiff = findMaxProfitDivideAndConquer(prices);
        assertEquals(0L, maxDiff);
    }

    @Test
    public void divideAndConquer_NullArray_RuntimeException() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            List<Long> prices = null;
            Long maxDiff = findMaxProfitDivideAndConquer(prices);
            assertEquals(0L, maxDiff);
        });
    }

    @Test
    public void divideAndConquer_OneElemArray_Zero() {
        List<Long> prices = new ArrayList<>();
        prices.add(1L);
        Long maxDiff = findMaxProfitDivideAndConquer(prices);
        assertEquals(0L, maxDiff);
    }

    @Test
    public void divideAndConquer_AscendingPrices_DiffBetweenFirstAndLastDaysProfit() {
        List<Long> prices = new ArrayList<>();
        prices.add(1L);
        prices.add(3L);
        prices.add(5L);
        Long maxDiff = findMaxProfitDivideAndConquer(prices);
        assertEquals(4L, maxDiff);
    }

    @Test
    public void divideAndConquer_DescendingPrices_ZeroProfit() {
        List<Long> prices = new ArrayList<>();
        prices.add(5L);
        prices.add(3L);
        prices.add(1L);
        Long maxDiff = findMaxProfitDivideAndConquer(prices);
        assertEquals(0L, maxDiff);
    }

    @Test
    public void divideAndConquer_MixedPrices1_BiggestDiffProfit() {
        List<Long> prices = new ArrayList<>();
        prices.add(1L);
        prices.add(5L);
        prices.add(3L);
        Long maxDiff = findMaxProfitDivideAndConquer(prices);
        assertEquals(4L, maxDiff);
    }

    @Test
    public void divideAndConquer_MixedPrices2_BiggestDiffProfit() {
        List<Long> prices = new ArrayList<>();
        prices.add(1L);
        prices.add(3L);
        prices.add(1L);
        prices.add(4L);
        Long maxDiff = findMaxProfitDivideAndConquer(prices);
        assertEquals(3L, maxDiff);
    }

    @Test
    public void divideAndConquer_MinAfterMax_BiggestDiffProfit() {
        List<Long> prices = new ArrayList<>();
        prices.add(10L);
        prices.add(1L);
        prices.add(6L);
        prices.add(1L);
        prices.add(8L);
        Long maxDiff = findMaxProfitDivideAndConquer(prices);
        assertEquals(7L, maxDiff);
    }
}
