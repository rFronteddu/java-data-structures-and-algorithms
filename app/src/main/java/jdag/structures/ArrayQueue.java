package jdag.structures;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class ArrayQueue <E>
{
    private E[] queue;
    private int front;
    private int back;
    private final Class<E> clazz;

    @SuppressWarnings ("unchecked")
    public ArrayQueue (final Class<E> clazz, final int capacity) {
        this.clazz = clazz;
        queue = (E[]) Array.newInstance (clazz, capacity);
    }

    @SuppressWarnings ("unchecked")
    public void add (final E e) {
        // weak impl, removing and adding items keeps resizing the queue, see circular queue impl for fix.
        if (back == queue.length) {
            var newArray = (E[]) Array.newInstance (clazz, 2 * queue.length);
            System.arraycopy (queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }
        queue[back++] = e;
    }

    public E remove () {
        if (size () == 0) {
            throw new NoSuchElementException ();
        }
        var e = queue[front];
        queue[front] = null;
        front++;
        if (size () == 0) {
            front = 0;
            back = 0;
        }
        return e;
    }

    public E peek () {
        if (size () == 0) {
            throw new NoSuchElementException ();
        }
        return queue[front];
    }

    public int size () {
        return back - front;
    }
}
