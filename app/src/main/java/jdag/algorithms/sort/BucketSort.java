package jdag.algorithms.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort
{
    public static void sort (final int[] input) {
        List<Integer>[] buckets = new List[10];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<> ();
        }

        for (int i = 0; i < input.length; i++) {
            buckets[hash (input[i])].add (input[i]);
        }

        for (var bucket : buckets) {
            // modified insertion sort
            Collections.sort (bucket);
        }

        int j = 0;
        for (List<Integer> bucket : buckets) {
            for (int value : bucket) {
                input[j++] = value;
            }
        }
    }

    private static int hash (final int value) {
        return value / (int) 10 % 10;
    }
}
