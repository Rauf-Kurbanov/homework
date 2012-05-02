package uniqueList;

/**
 *
 * @author paRRadox
 */
public class NotExistException extends RuntimeException {
    
    @Override
    public String getMessage() {
        return "This element not exist in list.";
    }
}
