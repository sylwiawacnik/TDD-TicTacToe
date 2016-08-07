package pl.sylwia.tictactoe;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import pl.sylwia.tictactoe.TicTacToe;

public class TicTacToeTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void shouldThrowExceptionWhenXAxisRangeExceeded() {
		// given

		Integer x = 1;

		// when
		TicTacToe gra = new TicTacToe();
		exception.expect(RuntimeException.class);
		gra.makeMove(x + 4, x);
		exception.expect(RuntimeException.class);
		gra.makeMove(-x - 3, x);

		// then

	}

	@Test
	public void shoulThrowExceptionWhenYAxisRangeExceeded() {
		// given
		Integer x = 1;

		// when
		TicTacToe gra = new TicTacToe();
		exception.expect(RuntimeException.class);
		gra.makeMove(x, x + 4);
		exception.expect(RuntimeException.class);
		gra.makeMove(x, -x - 4);

		// then
	}

	@Test
	public void shouldThrowExceptionWhenAreaIsNotFree() {
		// given
		Integer x = 1;

		// when
		TicTacToe gra = new TicTacToe();
		gra.makeMove(x, x + 1);
		exception.expect(RuntimeException.class);
		gra.makeMove(x, x + 1);

	}

	@Test
	public void shouldStartX() {

		// when

		TicTacToe gra = new TicTacToe();
		String firstP = gra.nextPlayer();

		// then

		assertThat(firstP).isEqualTo("X");
	}

	@Test
	public void shouldBeOAfterX() {
		// given

		Integer x = 0;

		// when
		TicTacToe gra = new TicTacToe();
		gra.makeMove(x + 1, x);
		String player = gra.nextPlayer();

		// then

		assertThat(player).isEqualTo("O");

	}

	@Test
	public void shouldBeXAfterO() {
		// given
		Integer x = 0;

		// when
		TicTacToe gra = new TicTacToe();
		gra.makeMove(x + 1, x + 2);
		gra.makeMove(x, x);
		String player2 = gra.nextPlayer();

		// then
		assertThat(player2).isEqualTo("X");

	}

	@Test
	public void shouldPlayerWinIfPutThreeElementsVertical() {

		// given
		Integer x = 0;

		// when
		TicTacToe gra = new TicTacToe();
		gra.makeMove(x, x);
		gra.makeMove(x, x + 1);
		gra.makeMove(x + 1, x);
		gra.makeMove(x, x + 2);
		gra.makeMove(x + 2, x);

		String winner = gra.winnerIs();

		// then

		assertThat(winner).isEqualTo("X");
	}

	@Test
	public void shoudlPlayerWinIfPutThreeElementsHorizontal() {

		// given
		Integer x = 0;

		// when
		TicTacToe gra = new TicTacToe();
		gra.makeMove(x, x);
		gra.makeMove(x + 1, x);
		gra.makeMove(x, x + 1);
		gra.makeMove(x + 2, x);
		gra.makeMove(x, x + 2);

		String winner = gra.winnerIs();

		// then

		assertThat(winner).isEqualTo("X");

	}

	@Test
	public void shoudlPlayerWinIfPutThreeElementsAcross() {

		// given
		Integer x = 0;

		// when
		TicTacToe gra = new TicTacToe();
		gra.makeMove(x, x);
		gra.makeMove(x, x + 1);
		gra.makeMove(x + 1, x + 1);
		gra.makeMove(x + 1, x);
		gra.makeMove(x + 2, x + 2);

		String winner = gra.winnerIs();

		// then

		assertThat(winner).isEqualTo("X");

	}

	@Test
	public void shoudlPlayerWinIfPutThreeElementsAcrossBack() {

		// given
		Integer x = 0;

		// when
		TicTacToe gra = new TicTacToe();
		gra.makeMove(x, x + 2);
		gra.makeMove(x, x + 1);
		gra.makeMove(x + 1, x + 1);
		gra.makeMove(x + 1, x);
		gra.makeMove(x + 2, x);

		String winner = gra.winnerIs();

		// then

		assertThat(winner).isEqualTo("X");

	}

	@Test
	public void shouldBeDeadHeat() {
		// given
		Integer x = 0;

		// when
		TicTacToe gra = new TicTacToe();
		gra.makeMove(x, x);
		gra.makeMove(x, x + 1);
		gra.makeMove(x, x + 2);
		gra.makeMove(x + 1, x);
		gra.makeMove(x + 1, x + 1);
		gra.makeMove(x + 1, x + 2);
		gra.makeMove(x + 2, x);
		gra.makeMove(x + 2, x + 1);
		gra.makeMove(x + 2, x + 2);
		
		String deadHeat = gra.checkIfIsDeadHeat();
		
		//then
		assertThat(deadHeat).isEqualTo("Dead-Heat");

	}

}
