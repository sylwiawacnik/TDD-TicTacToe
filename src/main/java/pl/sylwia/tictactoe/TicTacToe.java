package pl.sylwia.tictactoe;

public class TicTacToe {

	private String[][] board = new String[3][3];
	private String currentPlayer = "O";

	public void makeMove(Integer x, Integer y) {

		checkIfInputValueIsInRange(x);
		checkIfInputValueIsInRange(y);
		checkIfFieldIsEmpty(x, y);

		if (nextPlayer() == "X") {
			board[x][y] = "X";
			currentPlayer = "X";
		} else {
			board[x][y] = "O";
			currentPlayer = "O";
		}
	}

	private void checkIfFieldIsEmpty(Integer x, Integer y) {
		if (board[x][y] != null)
			throw new RuntimeException();
	}

	private void checkIfInputValueIsInRange(Integer InputValue) {
		if (InputValue >= 3 || InputValue < 0)
			throw new RuntimeException();
	}

	public String nextPlayer() {
		if (currentPlayer == "X")
			return "O";
		else
			return "X";

	}

	public String winnerIs() {

		return checkIfInRowsOrColumnsOrAcrossIsThreeTheSameElements();

	}

	private boolean checkColumnsAndRowsAndCross(int i, int j) {
		return board[j][i] != currentPlayer;
	}

	private String checkIfInRowsOrColumnsOrAcrossIsThreeTheSameElements() {
		for (int i = 0; i < 3; i++) {
			boolean isWinnerR = true;
			boolean isWinnerC = true;
			boolean isWinnerA = true;
			boolean isWinnerAB = true;
			for (int j = 0; j < 3; j++) {
				if (checkColumnsAndRowsAndCross(j, i))
					isWinnerC = false;
				if (checkColumnsAndRowsAndCross(i, j))
					isWinnerR = false;
				if (checkColumnsAndRowsAndCross(i, i))
					isWinnerA = false;
				if (checkColumnsAndRowsAndCross(2 - i, i))
					isWinnerAB = false;
			}
			if (isWinnerC == true || isWinnerR == true || isWinnerA == true || isWinnerAB == true)
				return currentPlayer;
		}
		return null;
	}

	public String checkIfIsDeadHeat() {
		if (checkIfInRowsOrColumnsOrAcrossIsThreeTheSameElements() == null) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (board[i][j] == null)
						return null;
				}
			}
		}
		return "Dead-Heat";
	}

}
