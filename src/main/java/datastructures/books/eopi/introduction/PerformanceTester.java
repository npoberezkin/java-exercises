package datastructures.books.eopi.introduction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static datastructures.books.eopi.introduction.MaxProfitFinder.*;
import static util.RandomDataGen.getRandomLongsList;

public class PerformanceTester {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceTester.class);

    public static void main(String[] args) {
        List<Long> randomLongsList = getRandomLongsList(100000, 0, 1000000);
        Long startBF = System.currentTimeMillis();
        Long maxProfitBruteForce = findMaxProfitBruteForce(randomLongsList);
        Long endBF = System.currentTimeMillis();
        LOGGER.info("BF: result - {}, time - {}", maxProfitBruteForce, (endBF - startBF));
        Long startDaC = System.currentTimeMillis();
        Long maxProfitDivideAndConquer = findMaxProfitDivideAndConquer(randomLongsList);
        Long endDaC = System.currentTimeMillis();
        LOGGER.info("DaC: result - {}, time - {}", maxProfitDivideAndConquer, (startDaC - endDaC));
        Long startL = System.currentTimeMillis();
        Long maxProfitByMinSoFar = findMaxProfitByMinSoFar(randomLongsList);
        Long endL = System.currentTimeMillis();
        LOGGER.info("L: result - {}, time - {}", maxProfitByMinSoFar, (startL - endL));
    }
}
