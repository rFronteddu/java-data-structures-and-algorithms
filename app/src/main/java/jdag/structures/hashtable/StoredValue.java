package jdag.structures.hashtable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StoredValue<E>
{
    public final String key;
    public final E value;
}
