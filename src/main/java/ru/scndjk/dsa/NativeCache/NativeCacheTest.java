package ru.scndjk.dsa.NativeCache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class NativeCacheTest {
    @Test
    public void testCacheEviction() {
        NativeCache<Integer> cache = new NativeCache<>(3);

        cache.put("key1", 1);
        cache.put("key2", 2);
        cache.put("key3", 3);

        cache.put("key4", 4);
        cache.put("key5", 5);
        cache.put("key6", 6);

        assertNull(cache.get("key1"));
        assertNull(cache.get("key2"));
        assertNull(cache.get("key3"));
        assertEquals(4, (int) cache.get("key4"));
        assertEquals(5, (int) cache.get("key5"));
        assertEquals(6, (int) cache.get("key6"));
    }

    @Test
    public void testHitsCount() {
        NativeCache<String> cache = new NativeCache<>(2);

        cache.put("key1", "value1");
        cache.put("key2", "value2");

        cache.get("key1");
        cache.get("key1");

        cache.put("key3", "value3");

        assertEquals("value1", cache.get("key1"));
        assertNull(cache.get("key2"));
        assertNull(null, cache.get("key3"));
    }
}

