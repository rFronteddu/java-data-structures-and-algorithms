package jdag.algorithms.sort;

public class RadixSort
{
    /**
     * Start at the rightmost position, and sort based on each individual digit or letter position.
     * Continue until all the digits have been considered.
     *
     * This particular implementation, does a stable counting sort for each digit until there are no
     * more digits
     * @param input object to order.
     */
    public static void sort (final int[] input, final int radix, final int width) {
        for (int i = 0; i < width; i++) {
            singleSort (input, i, radix);
        }
    }

    private static void singleSort (final int[] input, final int position, final int radix) {
        // items to sort
        int numItems = input.length;
        int[] countArray = new int[radix];

        for (int value : input) {
            // count all values for each digit
            countArray[getDigit (position, value, radix)]++;
        }
        // adjust counts to make them stable so that each position contains a value or less than that digit
        // sum count up to and including
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }
        // example: [0, 3, 1, 4]
        // number of values with a digit or less than that  digit in the position that we are working with
        // -> [0, 3, 4, 8]

        // copy into temporary array, from right to left to preserve relative order
        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit (position, input[tempIndex], radix)]] = input[tempIndex];
        }

        System.arraycopy (temp, 0, input, 0, numItems);
    }

    private static int getDigit (final int position, final int value, final int radix) {
        // take the n parameter, extract the digit by dividing it for
        // 10 * position, modulo radix will remove higher digits
        // example: value = 156, position 0 -> 156 % 10 = 6
        // example: value = 156, position 1 -> 15 % 10 = 5
        // example: value = 156, position 2 -> 1 % 10 = 1
        return (value / (int) Math.pow (10, position)) % radix;
    }
}
