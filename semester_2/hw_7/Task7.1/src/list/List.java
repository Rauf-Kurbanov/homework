package list;

/**
 *
 * @author paRRadox
 */

public interface List<T> extends Iterable<T> {
    /**
     * Appends the specified element to the end of this list
     *
     * @param value value of added element
     */
    public void add(T value);
    
    /**
     * Prints this list
     */
    public String print();
    
    /**
     * Removes all of the elements from this list
     */
    public void clear();
    
    /**
     * Returns true if this list contains all of the elements of the specified
     * collection
     *
     * @param value value of this element
     * @return true if this list contains all of the elements of the specified
     * collection
     */
    public boolean contains(T value);
    
    /**
     * Returns true if this list is empty
     *
     * @return true if this list is empty
     */
    public boolean isEmpty();
    
    /**
     * Removes the first occurrence in this list of the specified element
     *
     * @param value value of this element
     */
    public void remove(T value);
}
