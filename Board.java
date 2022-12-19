import java.util.Arrays;

class Board {
	private static int board_size;
	private char board[][];
	private final char blank;

	public Board(int board_size) {
		this.board_size = board_size;
		this.board = new char[board_size][board_size];
		this.blank = ' ';
		this.board = fillArray();
	}

	public char[][] fillArray() {
		for(int i = 0; i < this.board_size; ++i) {
			Arrays.fill(board[i], blank);
		}
		return board;
	}

	public void printBoard() {
		for (int i = 0; i < this.board_size; i++) {
			for (int j = 0; j < this.board_size; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
		}
	}


	public static void main(String[] args) {
		Board board = new Board(15);
		board.placeTile(7, 8, 'A');
		board.printBoard();
	}
}