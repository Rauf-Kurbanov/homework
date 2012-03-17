package main;

/**
 *
 * @author paRRadox
 */
public class Hashtable {
    protected int capasity = 500;
    protected List[] buckets;
    
    Hashtable(int capacity) {
        this.capasity = capacity;
        this.buckets = new List[capasity];
    }
    
    Hashtable() {
        this.buckets = new List[this.capasity];
    }
    
    protected int HashFunc(Object token) {
        return token.hashCode() % this.capasity;
    } 
}
