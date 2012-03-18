package main;

/**
 *
 * @author paRRadox
 */
public class Hashtable implements HashInterface {

    protected int capasity = 500;
    protected List[] buckets;

    Hashtable(int capacity) {
        this.capasity = capacity;
        this.buckets = new List[capasity];
        for (int i = 0; i < this.capasity; i++) {
            this.buckets[i] = new List();
        }
    }

    Hashtable() {
        this.buckets = new List[this.capasity];
        for (int i = 0; i < this.capasity; i++) {
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
    
    protected int hashFunc(String token) {
        return token.hashCode() % capasity;
    }
}
