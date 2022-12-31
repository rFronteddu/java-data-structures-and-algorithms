package jdag.algorithms;

public class Commons
{
    /**
     * Swap array[i] with array[j]
     * @param array array to swap
     * @param i first element
     * @param j second element
     */
    static void swap (final int[] array, final int i, final int j) {
        if (i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
