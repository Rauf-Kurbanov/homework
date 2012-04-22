package main;

/**
 *
 * @author paRRadox
 */
public class Hashtable implements HashInterface {

    
    /**
     * Creates a table of given capacity
     * @param capacity capasity of hashtable
     */
    public Hashtable(int capacity) {
        this.capacity = capacity;
        this.buckets = new List[capacity];
        for (int i = 0; i < this.capacity; i++) {
            this.buckets[i] = new List();
        }
    }
    
    /**
     * Creates a table of default capacity
     */
    public Hashtable() {
        this.buckets = new List[this.capacity];
        for (int i = 0; i < this.capacity; i++) {
            this.buckets[i] = new List();
        }
    }

    @Override
    public void addHT(String token) {
        buckets[hashFunc(token)].add(token);
    }

    @Override
    public boolean isExist(String token) {
        return (buckets[hashFunc(token)].isContains(token));
    }
    
    @Override
    public int size() {
        return buckets.length;
    }
    
    /**
     * Returnes hashcode of string
     * @param token string to hashcode
     * @return hash of token
     */
    private int hashFunc(String token) {
        return token.hashCode() % capacity;
    }
    
    private int capacity = 500;
    private List[] buckets;
    
}
