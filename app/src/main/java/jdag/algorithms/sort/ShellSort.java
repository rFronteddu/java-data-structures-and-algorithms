package jdag.algorithms.sort;

public class ShellSort
{
    /**
     * Variation of insert sort, instead of comparing only neighbors, start with a bigger gap and progressively
     * reduce the gap.
     *
     * @param array object to order.
     */
    public static void sort (final int[] array) {
        // start with a big gap, then reduce the gap, other more efficient functions to calculate the gap are possible
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            // perform a gap insertion sort for this gap size.
            // elements [0..gap -1] are gap sorted, add one more element until
            // the entire array is gap sorted.
            for (int i = gap; i < array.length; i++) {
                int newElement = array[i];

                // shift earlier gap-sorted elements up until the correct location for a[i] is found
                int j = i;
                while (j >= gap && array[j - gap] > newElement) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                // found insertion point
                array[j] = newElement;
            }
        }
    }
}
