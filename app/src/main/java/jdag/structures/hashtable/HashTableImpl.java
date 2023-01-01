package jdag.structures.hashtable;


public class HashTableImpl <E>
{
    private StoredValue<E>[] hashTable;

    private CollisionStrategy<E> collisionStrategy;

    public HashTableImpl (final Class<E> clazz, final CollisionStrategy<E> collisionStrategy) {
        //noinspection unchecked
        hashTable = (StoredValue<E>[]) new StoredValue[10];
        this.collisionStrategy = collisionStrategy;
    }

    public E get (final String key) {
        int hashKey = hashKey (key);
        hashKey = collisionStrategy.findKey (hashTable, key, hashKey);
        return hashKey == -1 ? null : hashTable[hashKey].value;
    }

    public void put (final String key, final E value) {
        int hashKey = hashKey (key);
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
        int hashKey = hashKey (key);
        if (hashTable[hashKey] == null && collisionStrategy == null) {
            throw new RuntimeException ("Sorry, no element was found at position " + hashKey + " and a collision strategy has not been defined.");
        }
        hashKey = collisionStrategy.findKey (hashTable, key, hashKey);
        var e = hashKey == -1 ? null : hashTable[hashKey].value;
        if (e != null) {
            hashTable[hashKey] = null;
        }
        return e;
    }

    private int hashKey (final String key) {
        // the more evenly the hashing function distributes the value,
        // the faster the retrieval
        return key.length () % hashTable.length;
    }
}
