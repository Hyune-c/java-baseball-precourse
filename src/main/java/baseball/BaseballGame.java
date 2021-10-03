package baseball;

import static config.Property.*;

import baseball.player.Computer;
import baseball.player.User;
import config.Property;
import controller.InputController;

public class BaseballGame {

	private static final String PRINT_WIN_GAME = NUMBER_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 끝.";

	private final Computer computer;

	private BaseballGame(final Computer computer) {
		this.computer = computer;
	}

	public static BaseballGame of(final Computer computer) {
		return new BaseballGame(computer);
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
	}

	/**
	 * 사용자의 입력으로 타석 결과를 반환합니다.
	 */
	private PlateAppearanceResult doBat() {
		final User user = User.of(InputController.nextIntegerList(Property.NUMBER_SIZE));
		return new PlateAppearanceResult(computer, user);
	}

	public void afterGame() {
		System.out.println(PRINT_WIN_GAME);
	}
}
