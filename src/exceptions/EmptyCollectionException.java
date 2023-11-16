package exceptions;
public class EmptyCollectionException extends RuntimeException {
    private String ecString;

    public EmptyCollectionException(String string) {this.ecString = string;}

    public String getEcString() {
        return this.ecString;
    }
}
