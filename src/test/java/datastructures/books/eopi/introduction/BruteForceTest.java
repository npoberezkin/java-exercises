package datastructures.books.eopi.introduction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static datastructures.books.eopi.introduction.MaxProfitFinder.findMaxProfitBruteForce;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BruteForceTest {

    @Test
    public void bruteForce_EmptyArray_Zero() {
        List<Long> prices = new ArrayList<>();
        Long maxDiff = findMaxProfitBruteForce(prices);
        assertEquals(0L, maxDiff);
    }

    @Test
    public void bruteForce_NullArray_RuntimeException() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            List<Long> prices = null;
            Long maxDiff = findMaxProfitBruteForce(prices);
            assertEquals(0L, maxDiff);
        });
    }

    @Test
    public void bruteForce_AscendingPrices_DiffBetweenFirstAndLastDaysProfit() {
        List<Long> prices = new ArrayList<>();
        prices.add(1L);
        prices.add(3L);
        prices.add(5L);
        Long maxDiff = findMaxProfitBruteForce(prices);
        assertEquals(4L, maxDiff);
    }

    @Test
    public void bruteForce_DescendingPrices_ZeroProfit() {
        List<Long> prices = new ArrayList<>();
        prices.add(5L);
        prices.add(3L);
        prices.add(1L);
        Long maxDiff = findMaxProfitBruteForce(prices);
        assertEquals(0L, maxDiff);
    }

    @Test
    public void bruteForce_MixedPrices1_BiggestDiffProfit() {
        List<Long> prices = new ArrayList<>();
        prices.add(1L);
        prices.add(5L);
        prices.add(3L);
        Long maxDiff = findMaxProfitBruteForce(prices);
        assertEquals(4L, maxDiff);
    }

    @Test
    public void bruteForce_MixedPrices2_BiggestDiffProfit() {
        List<Long> prices = new ArrayList<>();
        prices.add(1L);
        prices.add(3L);
        prices.add(1L);
        prices.add(4L);
        Long maxDiff = findMaxProfitBruteForce(prices);
        assertEquals(3L, maxDiff);
    }

    @Test
    public void bruteForce_MinAfterMax_BiggestDiffProfit() {
        List<Long> prices = new ArrayList<>();
        prices.add(10L);
        prices.add(1L);
        prices.add(6L);
        prices.add(1L);
        prices.add(8L);
        Long maxDiff = findMaxProfitBruteForce(prices);
        assertEquals(7L, maxDiff);
    }
}
