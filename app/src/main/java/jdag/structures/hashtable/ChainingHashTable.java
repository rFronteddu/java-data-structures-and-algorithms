package jdag.structures.hashtable;

import java.util.LinkedList;

public class ChainingHashTable <E> implements HashTableInterface<E>
{
    private final LinkedList<StoredValue<E>>[] hashTable;

    public ChainingHashTable () {
        hashTable = new LinkedList[10];
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new LinkedList<> ();
        }
    }

    @Override public void put (final String key, final E value) {
        int hashedKey = hashKey (key, hashTable.length);
        hashTable[hashedKey].add (new StoredValue<> (key, value));
    }

    @Override public E remove (String key) {
        int hashedKey = hashKey (key, hashTable.length);
        var it = hashTable[hashedKey].listIterator ();
        while (it.hasNext ()) {
            var next = it.next ();
            if (next.key.equals (key)) {
                it.remove ();
                return next.value;
            }
        }
        return null;
    }

    @Override public E get (String key) {
        int hashedKey = hashKey (key, hashTable.length);
        for (StoredValue<E> el : hashTable[hashedKey]) {
            if (el.key.equals (key)) {
                return el.value;
            }
        }
        return null;
    }
}
