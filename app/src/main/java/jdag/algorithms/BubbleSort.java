package jdag.algorithms;

public class BubbleSort
{
    /**
     * Compare each couple of elements swapping to the right the largest one. Repeat until all elements
     * are sorted.
     * @param array object to order.
     */
    public static void sort (final int[] array) {
        for (int lastUnSortedIndex = array.length - 1; lastUnSortedIndex > 0; lastUnSortedIndex--) {
            for (int i = 0; i < lastUnSortedIndex; i++) {
                if (array[i] > array[i + 1]) {
                    Commons.swap (array, i, i + 1);
                }
            }
        }
    }
}
