package controller;

import java.util.List;

import baseball.utils.ParseUtils;
import config.Property;
import nextstep.utils.Console;

public class InputController {

	private static final String INPUT_RETRY_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String INPUT_RETRY = "[ERROR] 다시 입력해주세요.";
	private static final String INPUT_NUMBERS = "숫자를 입력해 주세요 : ";

	private InputController() {
	}

	public static List<Integer> nextIntegerList(final int size) {
		try {
			System.out.print(INPUT_NUMBERS);
			return ParseUtils.parse(Console.readLine(), size);
		} catch (final IllegalArgumentException ex) {
			System.out.println(INPUT_RETRY);
			return nextIntegerList(size);
		}
	}

	public static int nextGameStatusTypeFlag() {
		try {
			System.out.println(INPUT_RETRY_GAME);
			return ParseUtils.parse(Console.readLine(), Property.TYPE_FLAG_LENGTH).get(0);
		} catch (final IllegalArgumentException ex) {
			System.out.println(INPUT_RETRY);
			return nextGameStatusTypeFlag();
		}
	}
}
