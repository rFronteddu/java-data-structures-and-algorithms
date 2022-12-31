package jdag.structures.stack;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ArrayStackImplTest
{
    @Test public void addToFrontTest () {
        SimpleStack<String> stack = new ArrayStackImpl<> (String.class, 2);
        stack.push ("1");
        stack.push ("2");
        stack.push ("3");
        stack.push ("4");
        assertEquals (stack.pop (), "4");
        assertEquals (stack.pop (), "3");
        assertEquals (stack.pop (), "2");
        assertEquals (stack.pop (), "1");
        assertNull (stack.pop ());
    }
}