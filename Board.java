import java.util.Arrays;

public class Board extends Tile {
	private int board_size;
	public static String board[][];
	private final String blank;

	public Board(int board_size) {
		this.board_size = board_size;
		board = new String[board_size][board_size];
		this.blank = " ";
		board = fillArray();
	}

	public String[][] fillArray() {
		for(int i = 0; i < this.board_size; ++i) {
			Arrays.fill(board[i], blank);
		}
		return board;
	}

	public void printBoard() {
		for(int i = 0; i < this.board_size - 1; i++) {
			for(int j = 0; j < this.board_size; j++) {
				if(j == this.board_size - 1)
					System.out.println(" |");
				else
					System.out.print(" | " + board[i][j]);
			}
		}
	}

	public String getTile(int row, int col) {
		return board[row][col];
	}


	public static void main(String[] args) {
		Board board = new Board(16);
		board.applyDW();
		board.applyStar();
		board.printBoard();
	}

	public int getBoard_size() {
		return board_size;
	}

	public void setBoard_size(int board_size) {
		this.board_size = board_size;
	}

	public static String[][] getBoard() {
		return board;
	}

	public void setBoard(String[][] newboard) {
		board = newboard;
	}

	public String getBlank() {
		return blank;
	}
}