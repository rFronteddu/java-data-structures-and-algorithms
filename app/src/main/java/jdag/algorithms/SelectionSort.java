package jdag.algorithms;

import static jdag.algorithms.Commons.swap;

public class SelectionSort
{
    /**
     * Traverse the array looking for the largest element, swap with the last unsorted element. Repeat.
     * @param array object to sort.
     */
    public static void sort (final int[] array) {
        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largestIndex = 0;
            for (int i = 0; i <= lastUnsortedIndex; i++) {
                if (array[i] > array[largestIndex]) {
                    largestIndex = i;
                }
            }
            swap (array, largestIndex, lastUnsortedIndex);
        }
    }
}
