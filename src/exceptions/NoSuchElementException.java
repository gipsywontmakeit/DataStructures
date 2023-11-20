package exceptions;

/**
 * NoSuchElementException is thrown when a method attempts to access an element
 */
public class NoSuchElementException extends RuntimeException {

    /**
     * ecString is a string that is passed to the constructor of the EmptyCollectionException class
     */
    private String ecString;

    /**
     * NoSuchElementException constructor that takes in a string and passes it to the RuntimeException constructor.
     * @param string is the string that is passed to the RuntimeException constructor.
     */
    public NoSuchElementException(String string) {this.ecString = string;}

    /**
     * getEcString method returns the string that is passed to the constructor of the EmptyCollectionException class.
     * @return the string that is passed to the constructor of the EmptyCollectionException class.
     */
    public String getEcString() {
        return this.ecString;
    }
}
