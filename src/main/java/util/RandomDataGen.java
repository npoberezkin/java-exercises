package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.LongStream;

public class RandomDataGen {

    public static List<Long> getRandomLongsList(int size, int origin, int bound) {
        Random random = new Random();
        LongStream currentStream = random.longs(size, origin, bound);
        long[] currents = currentStream.toArray();
        List<Long> prices = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            prices.add(Long.valueOf(currents[i]));
        }
        return prices;
    }
}
