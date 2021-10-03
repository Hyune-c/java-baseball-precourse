package baseball;

import static config.Property.*;

import java.util.ArrayList;
import java.util.List;

import baseball.player.Computer;
import baseball.player.User;
import config.Property;
import controller.InputController;
import type.GameStatusType;

public class BaseballGame {

	private static final String INPUT_NUMBERS = "숫자를 입력해 주세요 : ";
	private static final String PRINT_WIN_GAME = NUMBER_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 끝.";

	private final Computer computer;
	private final User user;

	private GameStatusType gameStatusType;

	public BaseballGame(final int numberSize) {
		this.computer = Computer.of(numberSize);
		this.user = User.of(new ArrayList<>());

		this.gameStatusType = GameStatusType.RESTART;
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
			System.out.println(plateAppearanceResult.generateMessage());
		} while (!plateAppearanceResult.isAllStrike());

		afterGame();
	}

	/**
	 * 사용자의 입력으로 타석 결과를 반환합니다.
	 */
	private PlateAppearanceResult doBat() {
		do {
			final List<Integer> inputNumberList = InputController.nextIntegerList(
				INPUT_NUMBERS, Property.NUMBER_SIZE);
			user.updateNumberList(inputNumberList);
		} while (!user.isValid());

		return new PlateAppearanceResult(computer, user);
	}

	private void afterGame() {
		System.out.println(PRINT_WIN_GAME);
		gameStatusType = GameStatusType.END;
	}

	public void askRestart() {
		int flag = 0;
		do {
			flag = InputController.nextGameStatusTypeFlag();
		} while (!GameStatusType.isValidFlag(flag));

		updateGameStatus(GameStatusType.findByFlag(flag));
		afterAskRestart();
	}

	private void afterAskRestart() {
		if (gameStatusType.equals(GameStatusType.RESTART)) {
			computer.reset();
		}
	}

	private void updateGameStatus(final GameStatusType newGameStatusType) {
		gameStatusType = newGameStatusType;
	}

	public boolean isRestart() {
		return gameStatusType.equals(GameStatusType.RESTART);
	}
}
