package jdag.algorithms.sort;

public class InsertionSort
{
    /**
     * Starting from the left, increase the size of the sorted array by once adding newElement each traversal. During
     * the traversal, shift elements to the right until the position of newElement is found. Assign newEl to the position.
     *
     * @param array object to order.
     */
    public static void sort (final int[] array) {
        // add element and sort, repeat
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
            int newElement = array[firstUnsortedIndex];
            int i;
            // looks for correct position starting from the end of the partition that is being sorted
            for (i = firstUnsortedIndex; i > 0 && array[i - 1] > newElement; i--) {
                array[i] = array[i - 1];
            }
            // once you found the correct position assign the newElement
            array[i] = newElement;
        }
    }
}
