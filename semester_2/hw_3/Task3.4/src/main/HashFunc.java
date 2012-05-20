package main;

/**
 *
 * @author paRRadox
 */
public interface HashFunc {
    
    /**
     * Returns the hash code value for this hashtable.
     * @param token value to get hash code
     * @param capasity size of hashtable
     * @return the hash code of token
     */
    public int hash(String token, int capasity);
}
