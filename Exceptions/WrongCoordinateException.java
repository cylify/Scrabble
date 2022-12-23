package Exceptions;

public class WrongCoordinateException extends Exception {
    private int x;
    private int y;

    public WrongCoordinateException(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String getMessage() {
        return "Error. The coordinate " + (char)(x + 'A') + (y + 1) + " are incorrect.";
    }
}
