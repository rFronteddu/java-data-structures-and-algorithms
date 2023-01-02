package jdag.algorithms.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchTests
{
    @Test public void linearTest () {
        int[] intArray = getArray ();
        assertEquals (2, LinearSearch.search (intArray, 29));
        assertEquals (-1, LinearSearch.search (intArray, 34444));
    }

    @Test public void binaryTest () {
        int[] intArray = getArray ();
        // note that the array got ordered
        assertEquals (2, BinarySearch.search (intArray, 29, true));
        assertEquals (-1, BinarySearch.search (intArray, 34444, true));

        assertEquals (2, BinarySearch.search (intArray, 29, false));
        assertEquals (-1, BinarySearch.search (intArray, 34444, false));
    }

    private static int[] getArray () {
        return new int[]{-15, 1, 29, 39, 59, 233};
    }
}