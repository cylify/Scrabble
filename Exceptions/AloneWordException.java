package Exceptions;

public class AloneWordException extends Exception {
    public String getMessage() {
        return "Error. At least one inserted letter must be next to a previously inserted one.";
    }
}