package controller;

import java.util.List;

import baseball.exception.InputParseException;
import baseball.utils.ParseUtils;
import config.Property;
import nextstep.utils.Console;

public class InputController {

	private static final String INPUT_RETRY_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String INPUT_NUMBERS = "숫자를 입력해 주세요 : ";

	private InputController() {
	}

	public static List<Integer> nextIntegerList(final int length) {
		System.out.print(INPUT_NUMBERS);

		try {
			return ParseUtils.parse(Console.readLine(), length);
		} catch (final InputParseException ex) {
			System.out.println(ex.getMessage());
			return nextIntegerList(length);
		}
	}

	public static int nextGameStatusTypeFlag() {
		System.out.println(INPUT_RETRY_GAME);

		try {
			return ParseUtils.parse(Console.readLine(), Property.TYPE_FLAG_LENGTH).get(0);
		} catch (final InputParseException ex) {
			System.out.println(ex.getMessage());
			return nextGameStatusTypeFlag();
		}
	}
}
