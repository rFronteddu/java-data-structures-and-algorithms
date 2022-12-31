package jdag.structures.stack;

import java.lang.reflect.Array;

public class ArrayStackImpl <E> implements SimpleStack<E>
{
    private E[] stack;
    // next available position in the stack
    private int top;
    private final Class<E> clazz;

    @SuppressWarnings ("unchecked")
    public ArrayStackImpl (final Class<E> clazz, final int capacity) {
        // An important difference between arrays and generics is how
        // they enforce type checking. Specifically, arrays store and check
        // type information at runtime. Generics, however, check for type
        // errors at compile-time and don't have type information at runtime.

        // unbound generic type T resolves to Object The code will compile fine, but fail at runtime with a ClassCastException. This is because we just assigned an Object[] to a E[] reference. Specifically, an implicit cast by the compiler will fail to convert Object[] to our required type E[].
        // stack = new E[capacity];
        this.clazz = clazz;
        stack = (E[]) Array.newInstance (clazz, capacity);
    }

    @SuppressWarnings ("unchecked")
    @Override public void push (final E e) {
        if (top == stack.length) {
            // need to resize
            // Resize O(n) part
            var tmp = (E[]) Array.newInstance (clazz, stack.length * 2);
            System.arraycopy (stack, 0, tmp, 0, stack.length);
            stack = tmp;
        }
        // O(1)
        stack[top++] = e;
    }

    @Override public E pop () {
        if (isEmpty ()) {
            return null;
        }
        var tmp = stack[--top];
        stack[top] = null;
        return tmp;
    }

    @Override public E peek () {
        if (isEmpty ()) {
            return null;
        }
        return stack[top - 1];
    }

    public boolean isEmpty () {
        return top == 0;
    }
}
