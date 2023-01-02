package jdag.algorithms.search;

/**
 * Search each element
 */
public class LinearSearch
{
    public static int search (final int[] input, final int value) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
