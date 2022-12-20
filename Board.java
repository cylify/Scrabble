import java.util.Arrays;

public class Board extends Tile {
	private int board_size;
	public static char board[][];
	private final char blank;

	public Board(int board_size) {
		this.board_size = board_size;
		board = new char[board_size][board_size];
		this.blank = ' ';
		board = fillArray();
	}

	public char[][] fillArray() {
		for(int i = 0; i < this.board_size; ++i) {
			Arrays.fill(board[i], blank);
		}
		return board;
	}

	public void printBoard() {
		for(int i = 0; i < this.board_size; i++) {
			for(int j = 0; j < this.board_size; j++) {
				if(j == 14)
					System.out.println(" |");
				else
					System.out.print(" | " + board[i][j]);
			}

		}
	}

	public void placeTile(int row, int col, char tile) {
		board[row][col] = tile;
	}

	public char getTile(int row, int col) {
		return board[row][col];
	}


	public static void main(String[] args) {
		Board board = new Board(15);
		// board.placeTile(7, 8, 'A');
		board.applyDW();
		board.printBoard();
	}

	public int getBoard_size() {
		return board_size;
	}

	public void setBoard_size(int board_size) {
		this.board_size = board_size;
	}

	public static char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] newboard) {
		board = newboard;
	}

	public char getBlank() {
		return blank;
	}
}