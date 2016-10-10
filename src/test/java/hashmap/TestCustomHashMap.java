package hashmap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCustomHashMap {

    @Test
    public void TestHashMapSizeMethod() {
        CMap map = new CustomHashMap();
        map.put(1, 10L);

        assertEquals("Should be 1 element in map", 1, map.size());
    }

    @Test
    public void TestHashMapSizeMethodWithDuplicatedKeys() {
        CMap map = new CustomHashMap();
        map.put(1, 10L);
        map.put(1, 15L);
        map.put(2, 25L);

        assertEquals("Should be 2 elements in map instead of 3", 2, map.size());
    }

    @Test
    public void TestHashMapGetMethodWithDifferentKeysAndValues() {
        CMap map = new CustomHashMap();
        map.put(1, 10L);
        map.put(2, 11L);
        map.put(3, 12L);

        long v1 = map.get(1);
        long v2 = map.get(2);
        long v3 = map.get(3);

        assertEquals("get() should return value 10 with key 1", 10L, v1);
        assertEquals("get() should return value 11 with key 2", 11L, v2);
        assertEquals("get() should return value 12 with key 3", 12L, v3);

        assertEquals("Should be 3 elements in map", 3, map.size());
    }

    @Test(expected = NullPointerException.class)
    public void TestShouldThrownNullPointerExceptionOnPutMethodWithNullKey() {
        CMap map = new CustomHashMap();
        map.put(null, 10L);
    }

    @Test(expected = RuntimeException.class)
    public void TestShouldThrownRuntimeExceptionOnPutMethodWithFullHashMap() {
        //default capacity of hashmap is 256
        CMap map = new CustomHashMap();

        for (int i = 0; i < 257; i++) {
            map.put(i, i + 10L);
        }
    }

    @Test
    public void TestHashMapInLoopForMaxCapacity() {
        //default capacity of hashmap is 256
        CMap map = new CustomHashMap();

        for (int i = 0; i < 256; i++) {
            map.put(i, i + 100L);
            assertEquals(Long.valueOf(i + 100), map.get(i));
        }
    }

}
