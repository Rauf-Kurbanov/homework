package main;

/**
 *
 * @author paRRadox
 */
public final class SquareHashFunc extends HashFunc {
    
    @Override
    public int hash(String token, int capasity) {
        int key = Integer.parseInt(token) * Integer.parseInt(token);
        key >>= 11;
        return key % capasity;
    }
}
