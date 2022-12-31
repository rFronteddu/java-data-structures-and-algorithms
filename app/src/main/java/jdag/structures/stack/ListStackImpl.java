package jdag.structures.stack;

import java.util.LinkedList;

public class ListStackImpl <E> implements SimpleStack<E>
{
    LinkedList<E> stack;

    public ListStackImpl () {
        stack = new LinkedList<> ();
    }

    @Override public void push (final E e) {
        stack.push (e);
    }

    @Override public E pop () {
        return stack.pop ();
    }

    @Override public E peek () {
        return stack.peek ();
    }

    public int size () {
        if (stack == null) {
            return 0;
        }
        return stack.size ();
    }

    public boolean isEmpty () {
        if (stack == null) {
            return true;
        }
        return stack.size () == 0;
    }
}