package hashmap;

public class Main {
    public static void main(String[] args) {
        CMap map = new CustomHashMap();
        map.put(100, 10000L);

        System.out.println(map.get(100));
    }
}
