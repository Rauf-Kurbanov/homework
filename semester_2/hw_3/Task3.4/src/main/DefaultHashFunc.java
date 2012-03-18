package main;

/**
 *
 * @author paRRadox
 */
public final class DefaultHashFunc extends AbstractHashFunc {

    @Override
    public int hash(String token, int capasity) {
        return token.hashCode() % capasity;
    }
}
