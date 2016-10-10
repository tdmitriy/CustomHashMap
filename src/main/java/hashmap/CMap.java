package hashmap;

public interface CMap {
    int size();
    void put(Integer key, Long value);
    Long get(Integer key);
}
