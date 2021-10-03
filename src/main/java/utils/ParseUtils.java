package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import exception.InputParseException;

public class ParseUtils {

	private ParseUtils() {
	}

	public static List<Integer> parse(final String input, final int length) {
		if (input.length() == length) {
			return new ArrayList<>(parseToIntegerList(input));
		}

		throw new InputParseException();
	}

	private static List<Integer> parseToIntegerList(final String input) {
		try {
			return Arrays.stream(input.split(""))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		} catch (final NumberFormatException ex) {
			throw new InputParseException();
		}
	}
}
