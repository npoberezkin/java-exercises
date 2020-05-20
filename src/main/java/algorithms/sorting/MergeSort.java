package algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

    private static void merge(int[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int lSize = m - l + 1;
        int rSize = r - m;

        /* Create temp arrays */
        int[] lArr = new int[lSize];
        int[] rArr = new int[rSize];

        /*Copy data to temp arrays*/
        for (int i = 0; i < lSize; ++i)
            lArr[i] = arr[l + i];
        for (int j = 0; j < rSize; ++j)
            rArr[j] = arr[m + 1 + j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < lSize && j < rSize) {
            if (lArr[i] <= rArr[j]) {
                arr[k] = lArr[i];
                i++;
            } else {
                arr[k] = rArr[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < lSize) {
            arr[k] = lArr[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < rSize) {
            arr[k] = rArr[j];
            j++;
            k++;
        }
    }

    private static void sort(int[] arr, int l, int r) {
        int m = l + (r - l) / 2;
        if (l < r) {
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 3, 5, 10, 2, 1, 4};
        System.out.println(Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
