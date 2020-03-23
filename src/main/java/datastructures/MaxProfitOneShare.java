package datastructures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.LongStream;

public class MaxProfitOneShare {

    static final int DAYS_RANGE = 40;

    public static void main(String[] args) {
        List<MinMaxStartPrice> prices = getRandomPrices(DAYS_RANGE);

        Long maxDiff = findMaxDiff(prices);

        System.out.println(maxDiff);
    }

    static List<MinMaxStartPrice> getRandomPrices(int size) {
        Random random = new Random();
        LongStream minStream = random.longs(size, 0, 100);
        LongStream maxStream = random.longs(size, 200, 300);
        LongStream startStream = random.longs(size, 100, 200);
        long[] mins = minStream.toArray();
        long[] maxs = maxStream.toArray();
        long[] starts = startStream.toArray();
        List<MinMaxStartPrice> prices = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            prices.add(new MinMaxStartPrice(Long.valueOf(mins[i]), Long.valueOf(maxs[i]), Long.valueOf(starts[i])));
        }
        return prices;
    }

    static Long findMaxDiff(List<MinMaxStartPrice> prices) {
        Long diff = 0L;
        Long currentStart = prices.get(0).getStart();
        for (int i = 1; i < prices.size(); i++) {
            for (int j = i; j < prices.size(); j++) {
                if (prices.get(j).start - currentStart > diff) {
                    diff = prices.get(j).start - currentStart;
                }
            }
            currentStart = prices.get(i).getStart();
        }
        return diff;
    }

    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    static class MinMaxStartPrice {
        private Long min;
        private Long max;
        private Long start;
    }
}
