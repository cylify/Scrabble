package Model;

import Exceptions.*;
import java.util.Random;
import java.util.ArrayList;

class Scrabble {
	private int round;
    private int turn;
    
    private ArrayList<Player> players;
    private Board board;
    private Bag bag;

    public Scrabble() throws WrongCoordinateException {
        this.players = new ArrayList<>();

        board = new Board();
        bag = new Bag();

        this.round = 0;
    }

    public Scrabble(ArrayList<Player> players) throws WrongCoordinateException, NoLettersInBagException {
        this.players = players;

        board = new Board();
        bag = new Bag();

        this.round = 0;
        turn = (new Random()).nextInt(players.size());

        for (Player p : players)
            p.refillRack(bag);
    }

    public void fillPlayerRack() throws NoLettersInBagException {
        players.get(turn).refillRack(bag);
    }

    public Player nextTurn() {
        turn++;
        if (turn >= players.size()) {
            turn = 0;
        }
        return players.get(turn);
    }

    public int playTurn(Word word) throws WrongWordException, OutOfBoundsException, OccupiedTileException, NoLetterInCenterException, AloneWordException {
        return board.playWord(word);
    }

    public Letter playTurn(Letter Letter) throws NoLettersInBagException {
        return bag.changeLetter(Letter);
    }

    public int getTurn() {
        return turn;
    }

    public Board getBoard() { return board; }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;

        turn = (new Random()).nextInt(players.size());
    }

    public Player getCurrentPlayer() {
        return players.get(turn);
    }

    public Player getBestPlayer() {
        Player bestPlayer = players.get(0);

        for (Player player: players) {
            if (player.getPlayerScore() > bestPlayer.getPlayerScore())
                bestPlayer = player;
        }

        return bestPlayer;
    }

    public Bag getBag() {
        return bag;
    }
}