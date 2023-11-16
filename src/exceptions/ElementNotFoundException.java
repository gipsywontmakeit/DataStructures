package exceptions;

public class ElementNotFoundException extends RuntimeException {
    private String ecString;

    public ElementNotFoundException(String string) {this.ecString = string;}

    public String getEcString() {
        return this.ecString;
    }
}
