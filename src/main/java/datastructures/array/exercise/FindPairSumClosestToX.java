package datastructures.array.exercise;

import java.util.Arrays;

/**
 * Given an array, we need to find a pair whose sum is closed to number X in Array.
 * Complexity O(n*log(n))
 */
public class FindPairSumClosestToX {

    public static void main(String[] args) {
        int[] arr = new int[]{-5, -3, -2, 0, 1, 3, 10, 6};
        findPairClosestToX(arr, 2);
    }

    private static void findPairClosestToX(int[] arr, int x) {
        Arrays.sort(arr);
        int min = 0;
        int max = arr.length - 1;
        int el1 = 0;
        int el2 = 0;
        int minDiff = Integer.MAX_VALUE;
        while (min < max) {
            int diff = arr[max] + arr[min] - x;
            if (Math.abs(diff) < minDiff) {
                el1 = arr[min];
                el2 = arr[max];
                minDiff = Math.abs(diff);
            }
            if (diff > 0) {
                max--;
            } else {
                min++;
            }
        }
        System.out.println("Pair which sum is closest to " + x + " is: " + el1 + " " + el2);
    }
}

