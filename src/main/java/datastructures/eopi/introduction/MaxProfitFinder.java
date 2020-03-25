package datastructures.eopi.introduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxProfitFinder {

    /**
     * Run time is proportional to ((n-1)*n)/2.
     * Time complexity - O(n^2)
     * Space complexity - O(n)
     *
     * @param pricesAtStart prices of stocks at start.
     * @return max profit possible.
     */
    static Long findMaxProfitBruteForce(List<Long> pricesAtStart) {
        if (pricesAtStart == null) {
            throw new RuntimeException("Array list can't be null");
        }
        if (pricesAtStart.size() == 0) {
            return 0L;
        }
        Long diff = 0L;
        Long currentStart = pricesAtStart.get(0);
        for (int i = 1; i < pricesAtStart.size(); i++) {
            for (int j = i; j < pricesAtStart.size(); j++) {
                if (pricesAtStart.get(j) - currentStart > diff) {
                    diff = pricesAtStart.get(j) - currentStart;
                }
            }
            currentStart = pricesAtStart.get(i);
        }
        return diff;
    }

    /**
     * Divide and conquer approach is used.
     * Array is divided into half and in both parts
     * the highest profit is counted individually.
     * Then we connect results (considering corner cases).
     * Time complexity - O(n*log(n))
     * Space complexity - O(n)
     *
     * @param pricesAtStart prices of stocks at start.
     * @return max profit possible.
     */
    static Long findMaxProfitDivideAndConquer(List<Long> pricesAtStart) {
        if (pricesAtStart == null) {
            throw new RuntimeException("Array list can't be null");
        }
        if (pricesAtStart.size() == 0 || pricesAtStart.size() == 1) {
            return 0L;
        }
        List<Long> leftHalf = pricesAtStart.subList(0, pricesAtStart.size() / 2);
        List<Long> rightHalf = pricesAtStart.subList(pricesAtStart.size() / 2, pricesAtStart.size());
        Long maxProfitLeft = findMaxInPart(leftHalf);
        Long maxProfitRight = findMaxInPart(rightHalf);
        Long minLeft = Collections.min(leftHalf);
        Long maxRight = Collections.max(rightHalf);
        Long maxProfitCross = maxRight - minLeft;
        return Collections.max(new ArrayList<>(Arrays.asList(maxProfitLeft, maxProfitRight, maxProfitCross)));
    }

    private static Long findMaxInPart(List<Long> pricesAtStart) {
        Long diff = 0L;
        if (pricesAtStart.size() == 0) {
            return diff;
        }
        Long currentStart = pricesAtStart.get(0);
        for (int i = 1; i < pricesAtStart.size(); i++) {
            for (int j = i; j < pricesAtStart.size(); j++) {
                if (pricesAtStart.get(j) - currentStart > diff) {
                    diff = pricesAtStart.get(j) - currentStart;
                }
            }
            currentStart = pricesAtStart.get(i);
        }
        return diff;
    }

    /**
     * Finding max by memorizing minimum price so far
     * and counting difference between current and min so far.
     * Time complexity - O(n)
     * Space complexity - O(n)
     *
     * @param pricesAtStart prices of stocks at start.
     * @return max profit possible.
     */
    static Long findMaxProfitByMinSoFar(List<Long> pricesAtStart) {
        if (pricesAtStart == null) {
            throw new RuntimeException("Array list can't be null");
        }
        if (pricesAtStart.size() == 0 || pricesAtStart.size() == 1) {
            return 0L;
        }
        Long diff = 0L;
        Long min = pricesAtStart.get(0);
        for (int i = 1; i < pricesAtStart.size(); i++) {
            if (pricesAtStart.get(i) < min) {
                min = pricesAtStart.get(i);
            }
            if (pricesAtStart.get(i) - min > diff) {
                diff = pricesAtStart.get(i) - min;
            }
        }
        return diff;
    }
}
