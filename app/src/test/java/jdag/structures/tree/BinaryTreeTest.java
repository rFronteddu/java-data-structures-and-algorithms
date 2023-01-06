package jdag.structures.tree;


import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest
{
    @Test public void bstTest () {
        BinaryTree bt = new BinaryTree ();
        bt.insert (25);
        bt.insert (20);
        bt.insert (15);
        bt.insert (27);
        bt.insert (30);
        bt.insert (29);
        bt.insert (26);
        bt.insert (22);
        bt.insert (32);

        //        System.out.println ("First Traversal");
        //bt.traverseInorder ();
        assertEquals (15, bt.get (15).getData ());
        assertNull (bt.get (99));
        assertEquals (32, bt.get (32).getData ());
        assertEquals (15, bt.min ());
        assertEquals (32, bt.max ());

        /*
            System.out.println ("Second Traversal");
            bt.traverseInorder ();
            System.out.println ("Third Traversal");
         */

        bt.delete (25);
        // bt.traverseInorder ();
        // System.out.println ("Fourth Traversal");
        bt.delete (32);
        // bt.traverseInorder ();
    }
}