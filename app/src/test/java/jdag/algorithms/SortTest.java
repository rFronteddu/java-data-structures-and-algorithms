package jdag.algorithms;

import jdag.algorithms.sort.*;
import jdag.structures.tree.heap.HeapTree;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class SortTest
{
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger (SortTest.class);

    // < ------------------------------------------------------------------------------------------------------------- >

    @Test public void bubbleSortTest () {
        int[] intArray = getRandomArray ();
        BubbleSort.sort (intArray);
        assertTrue (isSorted (intArray));
    }

    @Test public void countSortTest () {
        int[] intArray = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
        CountingSort.sort (intArray, 1, 10);
        assertTrue (isSorted (intArray));
    }

    @Test public void bucketSortTest () {
        int[] intArray = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
        BucketSort.sort (intArray);
        assertTrue (isSorted (intArray));
    }

    @Test public void insertionSortTest () {
        int[] intArray = getRandomArray ();
        InsertionSort.sort (intArray);
        assertTrue (isSorted (intArray));
    }

    @Test public void mergeSortTest () {
        int[] intArray = getRandomArray ();
        MergeSort.sort (intArray, 0, intArray.length);
        assertTrue (isSorted (intArray));
    }

    @Test public void heapSortTest () {
        HeapTree heapTree = new HeapTree (10);

        heapTree.insert (80);
        heapTree.insert (75);
        heapTree.insert (60);
        heapTree.insert (68);
        heapTree.insert (55);
        heapTree.insert (40);
        heapTree.insert (52);
        heapTree.insert (67);
        heapTree.sort ();
        isSorted (heapTree.heap);
    }

    @Test public void quickSortTest () {
        int[] intArray = getRandomArray ();
        QuickSort.sort (intArray, 0, intArray.length);
        assertTrue (isSorted (intArray));
    }

    @Test public void radixSortTest () {
        int[] radixArray = {5725, 5686, 1330, 8792, 1594, 5729};
        RadixSort.sort (radixArray, 10, 4);
        assertTrue (isSorted (radixArray));
    }

    @Test public void selectionSortTest () {
        int[] intArray = getRandomArray ();
        SelectionSort.sort (intArray);
        assertTrue (isSorted (intArray));
    }

    @Test public void shellSortTest () {
        int[] intArray = getRandomArray ();
        ShellSort.sort (intArray);
        assertTrue (isSorted (intArray));
    }

    /**
     *
     * @param array to check
     * @return true if the element of the array are ordered from the smallest to the largest
     */
    private static boolean isSorted (final int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (logger.isDebugEnabled ()) {
                logger.debug ("Index: {}, Value: {}", i, array[i]);
            }
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static int[] getRandomArray () {
        // creating Random object
        Random rd = new Random ();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt ();
        }
        return arr;
    }
}
