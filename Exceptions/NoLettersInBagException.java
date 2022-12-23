package Exceptions;

public class NoLettersInBagException extends Exception {
    String message = "Error. No remaining letters in the bag.";

    public String getMessage() {
        return message;
    }
}
