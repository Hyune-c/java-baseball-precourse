package baseball;

import static config.Property.*;

import baseball.player.Computer;
import baseball.player.User;
import config.Property;
import controller.InputController;

public class BaseballGame {

	private static final String PRINT_WIN_GAME = NUMBER_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 끝.";

	private final Computer computer;

	public BaseballGame(final int numberSize) {
		this.computer = Computer.of(numberSize);
	}

	public static BaseballGame of(final int numberSize) {
		return new BaseballGame(numberSize);
	}

	/**
	 * 1. doBat() 을 통해 타석 결과를 받습니다.
	 * 2. 게임이 끝나면 afterGame() 을 통해 GameStatusType.END 로 업데이트 합니다.
	 */
	public void doGame() {
		PlateAppearanceResult plateAppearanceResult;
		do {
			plateAppearanceResult = doBat();
			System.out.println(plateAppearanceResult.message());
		} while (!plateAppearanceResult.isAllStrike());

		afterGame();
	}

	/**
	 * 사용자의 입력으로 타석 결과를 반환합니다.
	 */
	private PlateAppearanceResult doBat() {
		final User user = User.of(InputController.nextIntegerList(Property.NUMBER_SIZE));
		return new PlateAppearanceResult(computer, user);
	}

	private void afterGame() {
		System.out.println(PRINT_WIN_GAME);
	}
}
