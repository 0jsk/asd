package ru.scndjk.dsa.NativeDictionary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NativeDictionaryTest {
    private NativeDictionary<String> dictionary;

    @BeforeEach
    void setUp() {
        dictionary = new NativeDictionary<>(10, String.class);
    }

    @Test
    @DisplayName("should put a new key-value pair and retrieve the value")
    void putNewKeyValuePair() {
        dictionary.put("key1", "value1");
        assertTrue(dictionary.isKey("key1"));
        assertEquals("value1", dictionary.get("key1"));
    }

    @Test
    @DisplayName("should update the value for an existing key")
    void putExistingKey() {
        dictionary.put("key1", "value1");
        dictionary.put("key1", "updatedValue");
        assertTrue(dictionary.isKey("key1"));
        assertEquals("updatedValue", dictionary.get("key1"));
    }

    @Test
    @DisplayName("should return true for an existing key")
    void isKeyExistingKey() {
        dictionary.put("key1", "value1");
        assertTrue(dictionary.isKey("key1"));
    }

    @Test
    @DisplayName("should return false for a non-existing key")
    void isKeyNonExistingKey() {
        assertFalse(dictionary.isKey("nonExistingKey"));
    }

    @Test
    @DisplayName("should retrieve the value for an existing key")
    void getExistingKey() {
        dictionary.put("key1", "value1");
        assertEquals("value1", dictionary.get("key1"));
    }

    @Test
    @DisplayName("should return null when retrieving a value for a non-existing key")
    void getNonExistingKey() {
        assertNull(dictionary.get("nonExistingKey"));
    }

    @Test
    @DisplayName("should rewrite the value for an existing key")
    void putExistingKeyRewriteValue() {
        dictionary.put("key1", "value1");
        dictionary.put("key1", "updatedValue");
        assertEquals("updatedValue", dictionary.get("key1"));
    }
}

