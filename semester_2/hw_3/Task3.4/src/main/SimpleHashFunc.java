package main;

/**
 *
 * @author paRRadox
 */
public class SimpleHashFunc extends AbstractHashFunc {

    @Override
    public int hash(String token, int capasity) {
        int hash = 0;
        for (int i = 0; i < token.length(); i++) {
            //hash += (int)token.charAt(i);
            hash += token.codePointAt(i);
        }
        return hash % capasity;
    }
}
