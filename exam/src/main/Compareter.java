package main;

/**
 *
 * @author paRRadox
 */
public class Compareter<E> {
    
    /**
     * Compares two value
     * @param a first value
     * @param b second value
     * @return : 1 if a > b; -1 if a < b; 0 if a == b. 
     */
    public int compare(E a, E b) {
        if (a.toString().charAt(0) > b.toString().charAt(0)) {
            return 1;
        } else if (a.toString().charAt(0) < b.toString().charAt(0)) {
            return -1;
        } else {
            return 0;
        }
    }
}
