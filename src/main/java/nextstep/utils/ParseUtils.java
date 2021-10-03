package nextstep.utils;

import java.util.ArrayList;
import java.util.List;

public class ParseUtils {

	public static List<Integer> parse(final String input, final int size) {
		final List<Integer> result = new ArrayList<>(parseToIntegerList(input));
		if (result.size() != size) {
			throw new IllegalArgumentException();
		}

		return result;
	}

	private static List<Integer> parseToIntegerList(final String input) {
		final List<Integer> inputNumbers = new ArrayList<>();
		for (final String num : input.split("")) {
			inputNumbers.add(Integer.parseInt(num));
		}

		return inputNumbers;
	}
}
