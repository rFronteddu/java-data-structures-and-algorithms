package jdag.structures.hashtable;

public class LinearProbing <E> implements CollisionStrategy<E>
{
    @Override public int manageCollision (final StoredValue<E>[] hashTable, final String key, final int hashKey) {
        // initialize probing
        int newHashKey = hashKey == hashTable.length - 1 ? 0 : hashKey + 1;

        // check until a place is found, or we roll back to the first hash -> not enough space
        while (isOccupied (hashTable, newHashKey) && newHashKey != hashKey) {
            newHashKey = (newHashKey + 1) % hashTable.length;
        }
        return isOccupied (hashTable, newHashKey) ? -1 : newHashKey;
    }

    @Override public int findKey (final StoredValue<E>[] hashTable, final String key, final int hashKey) {
        if (hashTable[hashKey] != null && hashTable[hashKey].key.equals (key)) {
            return hashKey;
        }

        // initialize probing
        int newHashKey = hashKey == hashTable.length - 1 ? 0 : hashKey + 1;
        while ((hashTable[newHashKey] == null || !hashTable[newHashKey].key.equals (key)) && newHashKey != hashKey) {
            newHashKey = (newHashKey + 1) % hashTable.length;
        }
        return hashTable[hashKey] != null && hashTable[newHashKey].key.equals (key) ? newHashKey : -1;
    }

    private boolean isOccupied (final StoredValue<E>[] hashTable, final int hashKey) {
        return hashTable[hashKey] != null;
    }
}
