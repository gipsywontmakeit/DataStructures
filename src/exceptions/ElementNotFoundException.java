package exceptions;

/**
 * ElementNotFoundException is a custom exception class that is thrown when an element is not found in a collection.
 */
public class ElementNotFoundException extends RuntimeException {

    /**
     * ecString is the string that is passed to the constructor of the exception.
     */
    private String ecString;

    /**
     * Constructor for ElementNotFoundException.
     * @param string is the string that is passed to the constructor of the exception.
     */
    public ElementNotFoundException(String string) {this.ecString = string;}

    /**
     * Getter for ecString.
     * @return ecString.
     */
    public String getEcString() {
        return this.ecString;
    }
}
