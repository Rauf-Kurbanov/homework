package set;

/**
 *
 * @author paRRadox
 */
public interface Set<E> {
    
    /**
     * Adds value to the set
     * @param value value to add
     */
    public void add(E value);
    
    /**
     * Removes the value from the set
     * @param value value to remove
     */
    public void remove(E value);
    
    /**
     * Gets union of sets
     * @param set set to unite with this set
     * @return union of sets
     */
    public Set<E> union(Set set);
    
    /**
     * Gets intersection of sets
     * @param set set to intersect with this set
     * @return intersection of sets
     */
    public Set<E> intersection(Set set);
    
    /**
     * Prints this set
     * @return string to print
     */
    public String print();
}
