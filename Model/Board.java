import java.util.ArrayList;

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

    private int checkOppositeDirection(Letter letter, Tile tile, Direction direction) {
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
            try {
                currentTile = getPreviousTile(currentTile, direction);
            } catch (OutOfBoundsException e) {
                break;
            }
        } while(!currentTile.isEmpty());

        try {
            currentTile = getNextTile(tile, direction);
        } catch (OutOfBoundsException e) {

        }

        do {
            if (!currentTile.isEmpty()) {
                score += currentTile.getLetter().getVal();
                newWord.add(currentTile.getLetter().getLetter());
            } else
                break;
            try {
                currentTile = getNextTile(currentTile, direction);
            } catch (OutOfBoundsException e) {
                break;
            }
        } while (!currentTile.isEmpty());

        String nw = "";
        for(char c : newWord)
            nw += c;

        if(!Dictionary.wordExists(nw) && nw.length() > 1)
            // throw new WrongWordException(nw);

        if(score > 0)
            System.out.println("Opposite word: " + nw + "\tScore: " + Integer.toString(score * multiplier));

        return score * multiplier;
    }

	private Tile getNextTile(Tile currentTile, Direction dir) {
        try {
            if(dir == Direction.HORIZONTAL)
                return board[currentTile.getX() + 1][currentTile.getY()];
            else
                return board[currentTile.getX()][currentTile.getY() + 1];
        } catch(Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void insertWord(Word word) {
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

    public int playWord(Word word) {
        int score = checkInsertion(word);
        insertWord(word);

        return score;
    }

    public int checkInsertion(Word word) {
        boolean validPosition = false;

        if (board[7][7].isEmpty()) {

            if (word.getDirection() == Direction.VERTICAL) {
                if (word.getOrigin().getX() != 7) {
                    // throw new NoLetgetLetterInCenterException();
                } else if (word.getOrigin().getY() > 7 ||
                        word.getOrigin().getY() + word.getLetters().size() < 7) {
                    // throw new NoLetgetLetterInCenterException();
                }
            } else {
                if(word.getOrigin().getY() != 7) {
                    // throw new NoLetgetLetterInCenterException();
                } else if(word.getOrigin().getX() > 7 || word.getOrigin().getX() + word.getLetters().size() < 7) {
                    // throw new NoLetgetLetterInCenterException();
                }
            }
            validPosition = true;
        }

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
            try {
                currentTile = getPreviousTile(currentTile, word.getDirection());
                if (!currentTile.isEmpty()) {
                    newWord.add(0, currentTile.getLetter().getLetter());
                    wordScore += currentTile.getLetter().getVal();
                    validPosition = true;
                }
            } catch (OutOfBoundsException e) {
                break;
            }
        } while (!currentTile.isEmpty());

        currentTile = word.getOrigin();

        for (Letter p : word.getLetters()) {
            // If the Letter was already inserted we don't want to
            // compute the score of its opposite direction
            while (!currentTile.isEmpty()) {
                newWord.add(currentTile.getLetter().getLetter());
                wordScore += currentTile.getLetter().getVal();
                currentTile = getNextTile(currentTile, word.getDirection());
                validPosition = true;
            }
            newWord.add(p.getLetter());
            wordScore += p.getVal() * currentTile.getLetterMultiplier();
            wordMultiplier *= currentTile.getWordMultiplier();
            extraWordsScore += checkOppositeDirection(p, currentTile, oppositeDir);

            if (word.getLetters().indexOf(p) != word.getLetters().size() - 1)
                currentTile = getNextTile(currentTile, word.getDirection());
        }

        try {
            do {
                currentTile = getNextTile(currentTile, word.getDirection());
                if (!currentTile.isEmpty()) {
                    newWord.add(currentTile.getLetter().getLetter());
                    wordScore += currentTile.getLetter().getVal();
                    validPosition = true;
                }
            } while (!currentTile.isEmpty());
        } catch (OutOfBoundsException e) {

        }

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