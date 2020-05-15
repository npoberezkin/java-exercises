package algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

    private static void sort1(int[] arr) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    sorted = false;
                    int swap = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = swap;
                }
            }
            System.out.println("iteration");
        }
    }

    private static void sort2(int[] arr) {
        boolean swapped = false;
        for (int i = 0; swapped && i < arr.length; i++) {
            System.out.println("iteration " + (i + 1));
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapped = true;
                    int swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{6, 3, 5, 10, 2, 1, 4};
        System.out.println(Arrays.toString(arr1));
        sort1(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[]{6, 1, 2, 3, 4, 6, 4};
        System.out.println(Arrays.toString(arr2));
        sort1(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}

