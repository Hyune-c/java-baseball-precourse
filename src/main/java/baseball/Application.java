package baseball;

import static config.Property.*;

import controller.InputController;
import type.GameStatusType;

public class Application {

	public static void main(final String[] args) {
		do {
			final BaseballGame baseGame = BaseballGame.of(NUMBER_SIZE);
			baseGame.doGame();
		} while (askRestart());
	}

	public static boolean askRestart() {
		try {
			final int flag = InputController.nextGameStatusTypeFlag();
			return GameStatusType.findByFlag(flag).isRestart();
		} catch (final IllegalArgumentException ex) {
			return askRestart();
		}
	}
}
