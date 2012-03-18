package main;

/**
 *
 * @author paRRadox
 */
public final class DefaultHashFunc extends HashFunc {

    @Override
    public int hash(String token, int capasity) {
        return token.hashCode() % capasity;
    }
}
