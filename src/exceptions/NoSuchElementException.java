package exceptions;

public class NoSuchElementException extends RuntimeException {
    private String ecString;

    public NoSuchElementException(String string) {this.ecString = string;}

    public String getEcString() {
        return this.ecString;
    }
}
