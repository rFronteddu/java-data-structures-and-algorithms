package jdag.structures;

import org.junit.Test;

public class SimpleLinkedListTest
{
    @Test public void addToFrontTest () {
        SimpleLinkedList<String> list = new SimpleLinkedList<> ();
        list.addToFront ("1");
        list.addToFront ("2");
        list.addToFront ("3");

        for (var e : list) {
            System.out.println (e);
        }
        assert (list.getSize () == 3);
    }

    @Test public void removeFromFrontTest () {
        SimpleLinkedList<String> list = new SimpleLinkedList<> ();
        list.addToFront ("1");
        list.addToFront ("2");
        list.addToFront ("3");

        list.removeFromFront ();
        list.removeFromFront ();
        list.removeFromFront ();
        assert (list.getSize () == 0);
    }
}