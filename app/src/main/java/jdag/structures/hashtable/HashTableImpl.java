package jdag.structures.hashtable;


public class HashTableImpl <E> implements HashTableInterface<E>
{
    private StoredValue<E>[] hashTable;

    private final CollisionStrategy<E> collisionStrategy;

    public HashTableImpl (final CollisionStrategy<E> collisionStrategy) {
        //noinspection unchecked
        hashTable = (StoredValue<E>[]) new StoredValue[10];
        this.collisionStrategy = collisionStrategy;
    }

    public E get (final String key) {
        int hashKey = hashKey (key, hashTable.length);
        hashKey = collisionStrategy.findKey (hashTable, key, hashKey);
        return hashKey == -1 ? null : hashTable[hashKey].value;
    }

    public void put (final String key, final E value) {
        int hashKey = hashKey (key, hashTable.length);
        if (hashTable[hashKey] == null) {
            hashTable[hashKey] = new StoredValue<> (key, value);
            return;
        }
        if (collisionStrategy == null) {
            throw new RuntimeException ("Sorry, there is already an element at position " + hashKey + " and a collision strategy has not been defined.");
        }
        var newHashKey = collisionStrategy.manageCollision (hashTable, key, hashKey);
        if (newHashKey == -1) {
            throw new RuntimeException ("Sorry, there is already an element at position " + hashKey + " and there is no more space.");
        }
        hashTable[newHashKey] = new StoredValue<> (key, value);
    }

    public E remove (final String key) {
        int hashKey = hashKey (key, hashTable.length);
        if (hashTable[hashKey] == null && collisionStrategy == null) {
            throw new RuntimeException ("Sorry, no element was found at position " + hashKey + " and a collision strategy has not been defined.");
        }
        hashKey = collisionStrategy.findKey (hashTable, key, hashKey);
        var e = hashKey == -1 ? null : hashTable[hashKey].value;
        if (e == null) {
            return null;
        }

        // rehash
        var oldTable = hashTable;
        //noinspection unchecked
        hashTable = (StoredValue<E>[]) new StoredValue[hashTable.length];
        for (StoredValue<E> eStoredValue : oldTable) {
            if (eStoredValue != null) {
                put (eStoredValue.key, eStoredValue.value);
            }
        }
        return e;
    }
}
