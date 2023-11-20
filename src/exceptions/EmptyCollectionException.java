package exceptions;

/**
 * EmptyCollectionException class is a custom exception class that is thrown when a collection is empty.
 */
public class EmptyCollectionException extends RuntimeException {

    /**
     * ecString is a string that is passed to the constructor of the EmptyCollectionException class.
     */
    private String ecString;

    /**
     * EmptyCollectionException constructor that takes in a string and passes it to the RuntimeException constructor.
     * @param string is the string that is passed to the RuntimeException constructor.
     */
    public EmptyCollectionException(String string) {this.ecString = string;}

    /**
     * getEcString method returns the string that is passed to the constructor of the EmptyCollectionException class.
     * @return the string that is passed to the constructor of the EmptyCollectionException class.
     */
    public String getEcString() {
        return this.ecString;
    }
}
