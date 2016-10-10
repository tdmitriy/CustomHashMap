package hashmap;

import java.util.Arrays;

/**
 * Implementation of HashMap with open addressing algorithm
 */
public class CustomHashMap implements CMap {

    // default size of HashMap (fixed size)
    private static final int DEFAULT_CAPACITY = 256;
    // size of key-value mappings in this map
    private int size = 0;

    private Entry[] entries;

    public CustomHashMap() {
        entries = new Entry[DEFAULT_CAPACITY];
        Arrays.fill(entries, null);
    }

    public int size() {
        return this.size;
    }

    public void put(Integer key, Long value) {
        if (key == null) throw new NullPointerException("The key cannot be null.");

        if (size == DEFAULT_CAPACITY)
            throw new RuntimeException(String.format("HashMap is full, cur size is: %s, max size is: %s",
                    size, DEFAULT_CAPACITY));


        int hash = hash(key);
        int rehash = hash;
        do {
            if (entries[rehash] == null) {
                entries[rehash] = new Entry(key, value);
                incrementSize();
                return;
            }
            if (entries[rehash].getKey().equals(key)) {
                entries[rehash].setValue(value);
                return;
            }
            // search the next free bucket with rehashing
            rehash = (rehash + 1) % DEFAULT_CAPACITY;
        } while (rehash != hash);

    }

    public Long get(Integer key) {
        int hash = hash(key);
        while (entries[hash] != null) {
            if (entries[hash].getKey().equals(key))
                return entries[hash].getValue();
            hash = (hash + 1) % DEFAULT_CAPACITY;
        }
        return null;
    }


    private int hash(Integer key) {
        return key.hashCode() % DEFAULT_CAPACITY;
    }

    private void incrementSize() {
        this.size++;
    }


    private static class Entry {
        private Integer key;
        private Long value;

        Entry(Integer key, Long value) {
            this.key = key;
            this.value = value;
        }

        Integer getKey() {
            return key;
        }

        Long getValue() {
            return value;
        }

        void setValue(Long value) {
            this.value = value;
        }
    }
}
