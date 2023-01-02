package jdag.algorithms.sort;

public class CountingSort
{
    /**
     * Count occurrences of each value and place as many in the position the value would be.
     * @param input object to order.
     */
    public static void sort (final int[] input, final int min, final int max) {
        int[] countArray = new int[max - min + 1];

        for (int k : input) {
            // remove the min to figure out the correct index of the element between min, max
            countArray[k - min]++;
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countArray[i - min] > 0) {
                // keep writing i element until there are no more occurrences
                input[j++] = i;
                countArray[i - min]--;
            }
        }
    }
}
