package Exceptions;

public class WrongWordException extends Exception {
    private String word;

    public WrongWordException(String word) {
        this.word = word;
    }

    @Override
    public String getMessage() {
        return "Error. The word " + word + " does not exist";
    }
}
