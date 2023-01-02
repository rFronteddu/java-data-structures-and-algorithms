package jdag.structures.hashtable;

public interface HashTableInterface <E>
{
    void put (final String key, final E value);

    E remove (final String key);

    E get (final String key);

    default int hashKey (final String key, final int len) {
        // the more evenly the hashing function distributes the value,
        // the faster the retrieval
        return key.length () % len;
    }
}
