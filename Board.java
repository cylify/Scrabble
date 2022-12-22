import java.util.Arrays;

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

	private Tile getNextTile(Tile currentTile, Direction dir) {
        try {
            if(dir == Direction.HORIZONTAL)
                return board[currentTile.getX() + 1][currentTile.getY()];
            else
                return board[currentTile.getX()][currentTile.getY() + 1];
        } catch(Exception e) {
            throw new OutOfBoundsException();
        }
    }

    private Tile getPreviousTile(Tile currentTile, Direction dir) throws OutOfBoundsException {
        try {
            if(dir == Direction.HORIZONTAL)
                return board[currentTile.getX() - 1][currentTile.getY()];
            else
                return board[currentTile.getX()][currentTile.getY() - 1];
        } catch(Exception e) {
            throw new OutOfBoundsException();
        }
    }

	private void fillBoard() {
        for(int i = 0; i < board_size; i++) {
            for(int j = 0; j < board_size; j++) {
                if(fillTW(i,j)) {
                    board[i][j] = new Tile(i, j , TileType.TRIPLEWORD);
                } else if (fillTL(i,j)) {
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