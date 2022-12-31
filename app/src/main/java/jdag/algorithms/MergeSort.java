package jdag.algorithms;

import java.awt.*;

public class MergeSort
{
    /**
     * During the splitting phase, we divide the input into two arrays.
     * The Left and right arrays are split again until all the arrays have only one element each.
     * Then, merge every pair of siblings into a sorted input. Merge again all the siblings ending up with a
     * bunch of 4-element sorted arrays. Repeat until the result is a single input.
     * @param input object to order.
     */
    public static void sort (final int[] input, final int start, final int end) {
        if (end - start < 2) {
            // input of one element -> break the recursion
            return;
        }

        // english speakers pronounce this as start + end over 2
        int mid = (start + end) / 2;
        // partition left input
        sort (input, start, mid);
        // partition right input
        sort (input, mid, end);
        merge (input, start, mid, end);
    }

    private static void merge (final int[] input, final int start, final int mid, final int end) {
        if (input[mid - 1] <= input[mid]) {
            // we are merging sorted partitions so if the last element in the left partition is smaller
            // than the first element in the right partition, it means that the two partitions are already
            // sorted
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        // compare whatever is left at the i input with whatever is right at the j input, place the
        // smaller in the current position is tempIndex

        // I want to stop as soon I traverse left to right (i == mid) or right to left (j == end)
        while (i < mid && j < end) {
            // the equal in this comparison preserves relative ordering
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        // if we have elements in the left partition we have to copy them, while the ones on the right
        // would be already ordered.

        // if we traverse the left, mid - i will be 0 and input copy will do nothing
        System.arraycopy (input, i, input, start + tempIndex, mid - i);

        // finally, copy elements from tempArray to input
        System.arraycopy (temp, 0, input, start, tempIndex);

    }
}
