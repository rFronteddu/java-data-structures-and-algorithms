package jdag.structures.tree.heap;


import org.junit.Test;
import static org.junit.Assert.*;

public class HeapTreeTest
{
    @Test public void heapTest () {
        HeapTree heapTree = new HeapTree (10);

        heapTree.insert (80);
        heapTree.insert (75);
        heapTree.insert (60);
        heapTree.insert (68);
        heapTree.insert (55);
        heapTree.insert (40);
        heapTree.insert (52);
        heapTree.insert (67);

        assertEquals (80, heapTree.peek ());
        assertEquals (75, heapTree.delete (1));

        assertEquals (80, heapTree.delete (0));
        assertEquals (68, heapTree.peek ());
//        heapTree.print();
    }
}