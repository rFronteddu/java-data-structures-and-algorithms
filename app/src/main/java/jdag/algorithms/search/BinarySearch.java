package jdag.algorithms.search;

import jdag.algorithms.sort.QuickSort;


/**
 * Search each element
 */
public class BinarySearch
{
    public static int search (final int[] input, final int value, final boolean iterative) {
        QuickSort.sort (input, 0, input.length);
        return iterative ? searchIterative (input, value) : searchRecursive (input, value);
    }

    public static int searchIterative (final int[] input, final int value) {
        int start = 0;
        int end = input.length;

        while (start < end) {
            int mid = (start + end) / 2;
            if (input[mid] == value) {
                return mid;
            }
            if (input[mid] > value) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int searchRecursive (final int[] input, final int value) {
        return recursiveBinarySearch (input, 0, input.length, value);
    }

    private static int recursiveBinarySearch (
            final int[] input,
            final int start,
            final int end,
            final int value) {
        if (start >= end) {
            return -1;
        }
        int mid = (start + end) / 2;

        if (input[mid] == value) {
            return mid;
        }

        if (input[mid] < value) {
            return recursiveBinarySearch (input, mid + 1, end, value);
        }
        return recursiveBinarySearch (input, start, mid, value);
    }
}
