package jdag.structures.stack;

public interface SimpleStack <E>
{
    /**
     * Add an item e as the top item on the stack
     * @param e item to add
     */
    void push (final E e);

    /**
     * Remove the top of the stack
     * @return top of the stack
     */
    E pop ();

    /**
     * Get the top item on the stack without popping it
     * @return top of the stack
     */
    E peek ();
}