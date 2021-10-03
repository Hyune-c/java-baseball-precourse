package baseball;

import static config.Property.*;

import baseball.player.Computer;
import controller.InputController;
import exception.InputParseException;
import type.GameStatusType;

public class Application {

	public static void main(final String[] args) {
		BaseballGame baseGame;
		do {
			baseGame = BaseballGame.of(Computer.of(NUMBER_LENGTH));
			baseGame.doGame();
		} while (askRestart());
	}

	public static boolean askRestart() {
		try {
			final int flag = InputController.nextGameStatusTypeFlag();
			return GameStatusType.findByFlag(flag).isRestart();
		} catch (final IllegalArgumentException ex) {
			System.out.println(new InputParseException().getMessage());
			return askRestart();
		}
	}
}
