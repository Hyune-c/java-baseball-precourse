package baseball;

import static config.Property.*;

public class Application {

	public static void main(final String[] args) {
		final BaseballGame baseGame = BaseballGame.of(NUMBER_SIZE);

		do {
			baseGame.doGame();
			baseGame.askRestart();
		} while (baseGame.isRestart());
	}
}
