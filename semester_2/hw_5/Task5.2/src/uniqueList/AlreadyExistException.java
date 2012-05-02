package uniqueList;

/**
 *
 * @author paRRadox
 */
public class AlreadyExistException extends RuntimeException {
    
    @Override
    public String getMessage() {
        return "This element already exist in list.";
    }
}
