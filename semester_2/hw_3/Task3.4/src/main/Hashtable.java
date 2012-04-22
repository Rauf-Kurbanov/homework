package main;

/**
 *
 * @author paRRadox
 */
public class Hashtable implements HashtableInterface {
    
    /**
     * Creates a table of given capacity
     * @param capacity capasity of hashtable
     * @param hashFunc hashfunction of this hashtable
     */
    public Hashtable(int capacity, HashFunc hashFunc) {
        this.capasity = capacity;
        this.buckets = new List[capasity];
        for (int i = 0; i < this.capasity; i++) {
            this.buckets[i] = new List();
        }
        this.hashFunc = hashFunc;
    }
    
    /**
     * Creates a table of default capacity
     * @param hashFunc hashfunction of this hashtable
     */
    public Hashtable(HashFunc hashFunc) {
        this.buckets = new List[this.capasity];
        for (int i = 0; i < this.capasity; i++) {
            this.buckets[i] = new List();
        }
        this.hashFunc = hashFunc;
    }

    @Override
    public void addHT(String token) {
        int index = hashFunc.hash(token, capasity);
        buckets[index].add(token);
    }

    @Override
    public boolean isExist(String token) {
        int index = hashFunc.hash(token, capasity);
        return (buckets[index].isContains(token));
    }

    @Override
    public int size() {
        return buckets.length;
    }
    
    private int capasity = 500;
    private List[] buckets;
    private HashFunc hashFunc;
}
