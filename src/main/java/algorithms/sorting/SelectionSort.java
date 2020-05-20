package algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int jMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[jMin]) {
                    jMin = j;
                }
            }
            if (jMin != i) {
                int swap = arr[i];
                arr[i] = arr[jMin];
                arr[jMin] = swap;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 3, 5, 10, 2, 1, 4};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
