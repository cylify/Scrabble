package Exceptions;
import Scrabble.Model.Tile;

public class OccupiedTileException extends Exception {
    private Tile tile;

    public OccupiedTileException(Tile tile) {
        this.tile = tile;
    }

    @Override
    public String getMessage() {
        return "Error. The Tile " + tile.toString() + " is occupied by " + tile.getLetter().toString() + ".";
    }
}
