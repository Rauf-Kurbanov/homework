package set;

import list.*;

/**
 *
 * @author paRRadox
 */
public class ListSet<E> implements Set<E> {
    
    @Override
    public void add(E value) {
        elements.add(value);
    }
    
    @Override
    public void remove(E value) {
        elements.remove(value);
    }
    
    @Override
     public Set<E> union(Set s) {
         return null;
     }
    
    @Override
    public Set<E> intersection(Set s) {
        return null;
    }
    
    @Override
    public String print() {
        return elements.print();
    }
    
    /**
     * Gets union of sets, works faster than default union
     * @param set set to unite with this set
     * @return union of sets
     */
    public ListSet<E> linkedUnion(ListSet<E> s) {
       ListSet<E> result = this;
       result.elements.merge(s.elements);
       return result;
    }
    
    public ListSet() {
        this.elements = new LinkedList<>();
    }
    
    private LinkedList<E> elements;
}
