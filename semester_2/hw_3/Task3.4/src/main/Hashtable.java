package main;

/**
 *
 * @author paRRadox
 */
public class Hashtable implements HashtableInterface {

    private int capasity = 500;
    private List[] buckets;
    private HashFunc HashFunc;

    Hashtable(int capacity, HashFunc HashFunc) {
        this.capasity = capacity;
        this.buckets = new List[capasity];
        for (int i = 0; i < this.capasity; i++) {
            this.buckets[i] = new List();
        }
        this.HashFunc = HashFunc;
    }

    Hashtable(HashFunc HashFunc) {
        this.buckets = new List[this.capasity];
        for (int i = 0; i < this.capasity; i++) {
            this.buckets[i] = new List();
        }
        this.HashFunc = HashFunc;
    }

    @Override
    public void addHT(String token) {
        int index = HashFunc.hash(token, capasity);
        buckets[index].add(token);
    }

    @Override
    public boolean isExist(String token) {
        int index = HashFunc.hash(token, capasity);
        return (buckets[index].isContains(token));
    }

    @Override
    public int size() {
        return buckets.length;
    }
}
