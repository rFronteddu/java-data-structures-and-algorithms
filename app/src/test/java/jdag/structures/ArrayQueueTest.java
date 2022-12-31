package jdag.structures;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest
{
    @Test public void addRemoveTest () {
        ArrayQueue<String> aq = new ArrayQueue<> (String.class, 10);
        aq.add ("1");
        aq.add ("2");
        aq.add ("3");
        assertEquals (aq.peek (), "1");
        assertEquals (aq.remove (), "1");
        assertEquals (aq.remove (), "2");
        assertEquals (aq.remove (), "3");
    }
}