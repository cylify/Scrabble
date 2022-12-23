package Model;

import java.util.ArrayList;
import Exceptions.*;

public class Board{
	private final int board_size = 16;
	public Tile board[][];

	
	public Board() {
		this.board = new Tile[board_size][board_size];
		fillBoard();

	}

	public Tile getTile(int x, int y) {
		return board[x][y];
	}

    private int checkOppositeDirection(Letter letter, Tile tile, Direction direction) throws WrongWordException, OutOfBoundsException {
        int score = 0;
        int multiplier = 1;
        ArrayList<Character> newWord = new ArrayList<>();

        newWord.add(letter.getLetter());

        Tile currentTile = tile;
        do {
            if (!currentTile.isEmpty()) {
                score += currentTile.getLetter().getVal();
                newWord.add(0, currentTile.getLetter().getLetter());
            }
            currentTile = getPreviousTile(currentTile, direction);
        } while(!currentTile.isEmpty());

        currentTile = getNextTile(tile, direction);

        do {
            if (!currentTile.isEmpty()) {
                score += currentTile.getLetter().getVal();
                newWord.add(currentTile.getLetter().getLetter());
            } else
                break;
            currentTile = getNextTile(currentTile, direction);
        } while (!currentTile.isEmpty());

        String nw = "";
        for(char c : newWord)
            nw += c;

        if(!Dictionary.wordExists(nw) && nw.length() > 1)
            throw new WrongWordException(nw);

        if(score > 0)
            System.out.println("Opposite word: " + nw + "\tScore: " + Integer.toString(score * multiplier));

        return score * multiplier;
    }

	private Tile getNextTile(Tile currentTile, Direction dir) throws OutOfBoundsException {
        try {
            if(dir == Direction.HORIZONTAL)
                return board[currentTile.getX() + 1][currentTile.getY()];
            else
                return board[currentTile.getX()][currentTile.getY() + 1];
        } catch(Exception e) {
            throw new OutOfBoundsException();
        }
    }

    private void insertWord(Word word) throws OutOfBoundsException {
        Tile currentTile = word.getOrigin();
        for(Letter p : word.getLetters()) {
            while(!currentTile.isEmpty()) {
                currentTile = getNextTile(currentTile, word.getDirection());
                board[currentTile.getX()][currentTile.getY()].setLetter(p);
            }
            if(word.getLetters().indexOf(p) != word.getLetters().size() - 1)
                currentTile = getNextTile(currentTile, word.getDirection());
        }
    }

    public int playWord(Word word) throws OutOfBoundsException, AloneWordException, NoLetterInCenterException, WrongWordException {
        int score = checkInsertion(word);
        insertWord(word);

        return score;
    }

    public boolean checkValid(boolean validPosition, Word word) throws NoLetterInCenterException {
        if(word.getDirection() == Direction.VERTICAL) {
            if(word.getOrigin().getX() != 7) {
                throw new NoLetterInCenterException();
            } else if(word.getOrigin().getY() > 7 || word.getOrigin().getY() + word.getLetters().size() < 7) {
                throw new NoLetterInCenterException();
            }
        } else {
            if(word.getOrigin().getY() != 7) {
                throw new NoLetterInCenterException();
            } else if(word.getOrigin().getX() > 7 || word.getOrigin().getX() + word.getLetters().size() < 7) {
                throw new NoLetterInCenterException();
            }
        }
        validPosition = true;
        return validPosition;
    }

    public int checkInsertion(Word word) throws OutOfBoundsException, AloneWordException, NoLetterInCenterException, WrongWordException {
        boolean validPosition = false;

        validPosition = checkValid(validPosition, word);

        int wordScore = 0;
        int extraWordsScore = 0;
        int wordMultiplier = 1;
        Direction oppositeDir;
        ArrayList<Character> newWord = new ArrayList<>();

        if(word.getDirection() == Direction.HORIZONTAL)
            oppositeDir = Direction.VERTICAL;
        else
            oppositeDir = Direction.HORIZONTAL;

        Tile currentTile = word.getOrigin();

        do {
            currentTile = getPreviousTile(currentTile, word.getDirection());
            if(!currentTile.isEmpty()) {
                newWord.add(0, currentTile.getLetter().getLetter());
                wordScore += currentTile.getLetter().getVal();
                validPosition = true;
            } else {

            }
        } while(!currentTile.isEmpty());

        currentTile = word.getOrigin();

        for (Letter l : word.getLetters()) {
            while (!currentTile.isEmpty()) {
                newWord.add(currentTile.getLetter().getLetter());
                wordScore += currentTile.getLetter().getVal();
                currentTile = getNextTile(currentTile, word.getDirection());
                validPosition = true;
            }
            newWord.add(l.getLetter());
            wordScore += l.getVal() * currentTile.getLetterMultiplier();
            wordMultiplier *= currentTile.getWordMultiplier();
            extraWordsScore += checkOppositeDirection(l, currentTile, oppositeDir);

            if (word.getLetters().indexOf(l) != word.getLetters().size() - 1)
                currentTile = getNextTile(currentTile, word.getDirection());
        }


        do {
            currentTile = getNextTile(currentTile, word.getDirection());
            if (!currentTile.isEmpty()) {
                newWord.add(currentTile.getLetter().getLetter());
                wordScore += currentTile.getLetter().getVal();
                validPosition = true;
            }
        } while(!currentTile.isEmpty());

        String nw = "";
        for (char c : newWord) nw += c;

        if(!Dictionary.wordExists(nw))
            // throw new WrongWordException(nw);

        if(extraWordsScore > 0) validPosition = true;

        if(!validPosition) 
            throw new AloneWordException();

        int totalScore = wordScore * wordMultiplier + extraWordsScore;

        System.out.println("Word: " + nw + "\tBase score: " + Integer.toString(wordScore * wordMultiplier) + "\tTotal Score: " + Integer.toString(totalScore));

        return totalScore;
    }

    private Tile getPreviousTile(Tile currentTile, Direction dir) {
        try {
            if(dir == Direction.HORIZONTAL)
                return board[currentTile.getX() - 1][currentTile.getY()];
            else
                return board[currentTile.getX()][currentTile.getY() - 1];
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }
    }

	private void fillBoard() {
        for(int i = 0; i < board_size; i++) {
            for(int j = 0; j < board_size; j++) {
                if(fillTW(i,j)) {
                    board[i][j] = new Tile(i, j , TileType.TRIPLEWORD);
                } else if(fillTL(i,j)) {
                    board[i][j] = new Tile(i, j , TileType.TRIPLELETTER);
                } else if(fillDW(i,j)) {
                    board[i][j] = new Tile(i, j, TileType.DOUBLEWORD);
                } else if(fillDL(i,j)) {
                    board[i][j] = new Tile(i, j , TileType.DOUBLELETTER);
                } else if(i == 7 && j == 7) {
                    board[i][j] = new Tile(i, j , TileType.STAR);
                } else {
                    board[i][j] = new Tile(i, j , TileType.PLAINTILE);
                }
            }
        }
    }

    public void print() {
    	for(int i = 0; i < this.board_size - 1; i++) {
			for(int j = 0; j < this.board_size; j++) {
				if(j == this.board_size - 1)
					System.out.println(" |");
				else
					System.out.print(" | " + board[i][j]);
			}
		}
    }

	private boolean fillTW(int i, int j) {
        boolean fill = false;

        if((i == 7) && (j == 0 || j == 14)) {
            fill = true;
        } else if((i == 0 || i == 14) && (j == 0 || j == 7 || j == 14 )) {
            fill = true;
        }

        return fill;
    }

    private boolean fillTL(int i, int j) {
        boolean fill = false;

        if ((i == 5 || i == 9) && (j == 1|| j == 5 || j == 9 || j == 13)) {
            fill = true;
        } else if ((i == 1 || i == 13) && (j == 5 || j == 9)) {
            fill = true;
        }

        return fill;
    }

    private boolean fillDW(int i, int j) {
        boolean fill = false;

        if((i == 1 || i == 13) && (j == 1|| j == 13)) {
            fill = true;
        } else if((i == 2 || i == 12) && (j == 2|| j == 12)) {
            fill = true;
        } else if((i == 3 || i == 11) && (j == 3|| j == 11)) {
            fill = true;
        } else if((i == 4 || i == 10) && (j == 4|| j == 10)) {
            fill = true;
        }  /*else if (i == 7 && j == 7) {
             fill = true;
        }*/

        return fill;
    }

    private boolean fillDL(int i, int j) {
        boolean fill = false;

        if((i == 1 || i == 14) && (j == 3|| j == 11)) {
            fill = true;
        } else if((i == 2 || i == 12) && (j == 6|| j == 8)) {
            fill = true;
        } else if((i == 3 || i == 11) && (j == 0|| j == 7 || j == 14)) {
            fill = true;
        } else if((i == 6 || i == 8) && (j == 2|| j == 6 || j == 8 || j == 12)) {
            fill = true;
        } else if((i == 7) && (j == 3|| j == 11)) {
            fill = true;
        }

        return fill;
    }
    public static void main(String[] args) {
    	Board board = new Board();
        board.print();
    }
}