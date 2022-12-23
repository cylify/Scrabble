package Exceptions;

public class NoLetterInCenterException extends Exception {
    public String getMessage() {
        return "Error. No letter placed in the middle.";
    }
}