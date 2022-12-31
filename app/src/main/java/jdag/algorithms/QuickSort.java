package jdag.algorithms;

public class QuickSort
{
    /**
     * Choose a pivot element and divide the input into two (logical) halves,
     * in the left half, put elements smaller than the pivot, in the right,
     * elements bigger than the pivot.
     * The pivot point will then be at the right position, repeat the process for left and right partitions.
     * @param input object to order.
     */
    public static void sort (final int[] input, final int start, final int end) {
        if (end - start < 2) {
            // 1 element array, nothing to do
            return;
        }
        int pivotIndex = partition (input, start, end);
        sort (input, start, pivotIndex);
        sort (input, pivotIndex + 1, end);
    }

    /**
     * Everything to the right of the pivot index will be larger than the pivot.
     * @return pivot index
     */
    private static int partition (final int[] input, final int start, final int end) {
        // using first element as pivot
        int pivot = input[start];

        // traversing left to right
        int i = start;

        // traversing right to left
        int j = end;

        // stop when i and j cross
        while (i < j) {
            // NOTE: empty loop body, decrement and use result
            while (i < j && input[--j] >= pivot) ;
            if (i < j) {
                // use j to find elements less than pivot, and move them left of the pivot
                input[i] = input[j];
            }

            // NOTE: empty loop body, decrement and use result
            while ((i < j && input[++i] <= pivot));

            if (i < j) {
                // use i to find elements bigger than pivot, and move them right of the pivot
                input[j] = input[i];
            }
        }
        input[j] = pivot;
        return j;
    }
}
