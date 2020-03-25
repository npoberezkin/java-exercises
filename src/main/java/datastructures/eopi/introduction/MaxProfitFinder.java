package datastructures.eopi.introduction;

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
        Long diff = 0L;
        if (pricesAtStart == null) {
            throw new RuntimeException("Array list can't be null");
        }
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

    static Long findMaxProfitDivideAndConquer(List<Long> pricesAtStart) {
        return 0L;
    }
}
