package day04;

import java.util.Arrays;

public class PairFinder {
    public static int findPairs(int[] arr) {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        int count = 0;
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] == sorted[i - 1]) {
                count++;
                i++;
            }
        }
        return count;
    }
}
