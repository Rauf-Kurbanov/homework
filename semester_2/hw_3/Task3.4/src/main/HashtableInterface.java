package main;

/**
 *
 * @author paRRadox
 */
public interface HashtableInterface {
    
   public void reBuild(HashFunc hashFunc);
    
    /**
     * Adds new value to hashtable
     *
     * @param token value to add
     */
    public void addHT(String token);

    /**
     * Checks if hashtable contains this value
     *
     * @param token value to check
     * @return true if this list contains the elements and false if not
     */
    public boolean isExist(String token);

    /**
     * Returns the size of hashtable
     *
     * @return the size of hashtable
     */
    public int size();
}
