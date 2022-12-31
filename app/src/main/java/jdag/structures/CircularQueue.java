package jdag.structures;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class CircularQueue <E>
{
    private E[] queue;
    private int front;
    private int back;
    private final Class<E> clazz;

    @SuppressWarnings ("unchecked")
    public CircularQueue (final Class<E> clazz, final int capacity) {
        this.clazz = clazz;
        queue = (E[]) Array.newInstance (clazz, capacity);
    }

    @SuppressWarnings ("unchecked")
    public void add (final E e) {
        if (size () == queue.length - 1) {
            int count = size ();
            var newArray = (E[]) Array.newInstance (clazz, 2 * queue.length);

            // copy from the front to the end
            System.arraycopy (queue, front, newArray, 0, queue.length - front);
            // copy the remaining items, I need to do this only when it wraps, so this could be improved with the right check
            System.arraycopy (queue, 0, newArray, queue.length - front, back);
            queue = newArray;

            front = 0;
            back = count;
        }
        queue[back] = e;
        back = back < queue.length - 1 ? back + 1 : 0;
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
        } else if (front == queue.length) {
            // must wrap
            front = 0;
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
        // no wrap : wrap
        return front <= back ? back - front : back - front + queue.length;
    }
}
