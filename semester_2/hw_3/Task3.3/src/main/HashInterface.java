package main;

/**
 *
 * @author paRRadox
 */
public interface HashInterface {
    /**
     * Adds new value to hashtable
     * @param token value to add
     */
    public void addHT(String token);
    
    /**
     * Checks if hashtable contains this value
     * @param token value to check
     * @return true if this list contains the elements and false if not
     */
    boolean isExist(String token);
    
    /**
     * Returns the size of hashtable
     * @return the size of hashtable
     */
    int size();
}
