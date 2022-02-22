package ru.job4j.gc.ref.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.putIfAbsent(key, new SoftReference<>(value));
    }

    public V get(K key) {
        V result = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (result == null) {
            result = load(key);
            put(key, result);
        }
        return result;
    }

    protected abstract V load(K key);

}
