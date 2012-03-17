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
    }

    Hashtable() {
        this.buckets = new List[this.capasity];
    }

    @Override
    public void addHT(String token) {
        this.buckets[HashFunc(token)].add(token);
    }

    @Override
    public boolean exist(String token) {
        return (this.buckets[HashFunc(token)].contains(token));
    }

    @Override
    public void printHt() {
        for (int i = 0; i < this.capasity; i++) {
            this.buckets[i].print();
        }
    }

    public int HashFunc(String token) {
        //return token.hashCode() % this.capasity;
        return (Integer.parseInt(token) + 19) % this.capasity;
    }
}
