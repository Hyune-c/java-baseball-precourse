package baseball;

import static config.Property.*;

import baseball.player.Computer;
import baseball.player.User;
import config.Property;
import controller.InputController;

public class BaseballGame {

	private static final String PRINT_WIN_GAME = NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 끝.";

	private final Computer computer;

	private BaseballGame(final Computer computer) {
		this.computer = computer;
	}

	public static BaseballGame of(final Computer computer) {
		return new BaseballGame(computer);
	}

	/**
	 * doBat() 을 통해 타석 결과를 받습니다.
	 */
	public void doGame() {
		PlateAppearanceResult plateAppearanceResult;
		do {
			plateAppearanceResult = doBat();
			System.out.println(plateAppearanceResult.message());
		} while (!plateAppearanceResult.isAllStrike());

		System.out.println(PRINT_WIN_GAME);
	}

	/**
	 * 사용자의 입력으로 타석 결과를 반환합니다.
	 */
	private PlateAppearanceResult doBat() {
		final User user = User.of(InputController.nextIntegers(Property.NUMBER_LENGTH));
		return PlateAppearanceResult.of(computer, user);
	}
}
