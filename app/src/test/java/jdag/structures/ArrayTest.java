package jdag.structures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Simple class test to demonstrate java arrays
 */
public class ArrayTest
{
    @Test public void loopTest () {
        int[] intArray = new int[7];
        intArray[0] = 20;
        intArray[1] = 30;
        intArray[2] = 40;
        intArray[3] = 50;
        intArray[4] = 60;
        intArray[5] = 70;
        intArray[6] = 80;

        int count = 0;
        for (int j : intArray) {
            count += j;
        }
        assertEquals ("Sum of array", 350, count);
    }
}
