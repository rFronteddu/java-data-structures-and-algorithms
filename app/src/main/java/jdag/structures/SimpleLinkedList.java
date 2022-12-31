package jdag.structures;

import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;

public class SimpleLinkedList <E> implements Iterable<E>
{
    static class ListIterator <E> implements Iterator<E>
    {
        Node<E> cursor;

        ListIterator (final SimpleLinkedList<E> simpleLinkedList) {
            cursor = simpleLinkedList.head;
        }

        @Override public boolean hasNext () {
            return cursor != null;
        }

        @Override public E next () {
            var e = cursor.e;
            cursor = cursor.next;
            return e;
        }

        @Override public void remove () {
            throw new UnsupportedOperationException ();
        }
    }

    @Override public ListIterator<E> iterator () {
        return new ListIterator<> (this);
    }

    static class Node <E>
    {
        public Node (final E e) {
            this.e = e;
        }

        @Setter
        Node<E> next;
        E e;
    }

    private Node<E> head;
    @Getter
    private int size;
    // < ------------------------------------------------------------------------------------------------------------- >

    public void addToFront (final E e) {
        Node<E> node = new Node<> (e);
        node.setNext (head);
        head = node;
        size++;
    }

    public E removeFromFront () {
        if (isEmpty ()) {
            return null;
        }
        size--;
        var tmp = head;
        head = head.next;
        return tmp.e;
    }


    public boolean isEmpty () {
        return head == null;
    }
}
