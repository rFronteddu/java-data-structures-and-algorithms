package jdag.structures;

import jdag.structures.hashtable.HashTableImpl;
import jdag.structures.hashtable.LinearProbing;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableImplTest
{
    @Test public void putGetTest () {
        HashTableImpl<String> hashTable = new HashTableImpl<> (null);
        hashTable.put ("test", "uno");
        hashTable.put ("test2", "due");
        assertEquals ("uno", hashTable.get ("test"));
    }

    @Test public void putGetRemoveLinearTest () {
        HashTableImpl<String> hashTable = new HashTableImpl<> (new LinearProbing<> ());
        var key1 = "test";
        var key2 = "ciao";
        var v1 = "uno";
        var v2 = "due";
        hashTable.put (key1, v1);
        hashTable.put (key2, v2);
        assertEquals (v1, hashTable.get (key1));
        assertEquals (v2, hashTable.get (key2));
        assertEquals (v2, hashTable.remove (key2));
        assertNull (hashTable.remove (key2));
        assertEquals (v1, hashTable.remove (key1));
        assertNull (hashTable.remove (key1));
        hashTable.put (key1, v1);
        assertEquals (v1, hashTable.get (key1));
    }

    @Test public void putGetRemoveLinearTest2 () {
        // this test requires re hashing
        HashTableImpl<String> hashTable = new HashTableImpl<> (new LinearProbing<> ());
        hashTable.put ("jones", "j");
        hashTable.put ("doe", "d");
        hashTable.put ("wilson", "mike");
        hashTable.put ("smith", "mary");

        hashTable.remove ("wilson");
        hashTable.remove ("jones");
        assertEquals ("mary", hashTable.get ("smith"));
    }
}