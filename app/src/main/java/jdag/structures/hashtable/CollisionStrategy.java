package jdag.structures.hashtable;

public interface CollisionStrategy <E>
{
    /**
     * Defines the contract for collision handling
     * @param hashTable under examination
     * @param key of new object
     * @param hashKey of key
     * @return valid hash for value or -1 if element doesn't fit
     */
    int manageCollision (final StoredValue<E>[] hashTable, final String key, final int hashKey);

    int findKey (final StoredValue<E>[] hashTable, final String key, final int hashKey);
}
