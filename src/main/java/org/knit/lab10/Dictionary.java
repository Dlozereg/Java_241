package org.knit.lab10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Dictionary<K, V> {
    HashMap<K, V> dict = new HashMap<>();

    public void put(K key, V value){
        dict.put(key, value);
    }

    public void remove(K key){
        dict.remove(key);
    }

    public V get(K key){
        return dict.get(key);
    }
}
