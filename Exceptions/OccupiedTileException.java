package Exceptions;
import Scrabble.model.Tile;

public class OccupiedTileException extends Exception {
    private Tile tile;

    public OccupiedTileException(Tile tile) {
        this.tile = tile;
    }

    @Override
    public String getMessage() {
        return "Error, the Tile " + tile.toString() + " is occupied by " + tile.getLetter().toString();
    }
}
