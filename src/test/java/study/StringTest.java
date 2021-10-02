package study;

import static java.util.Arrays.stream;
import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class StringTest {

	private static Stream<Arguments> split() {
		return Stream.of(
			Arguments.of("1,2", Arrays.array("1", "2")),
			Arguments.of("1", Arrays.array("1"))
		);
	}

	@DisplayName("[요구사항1] split")
	@ParameterizedTest
	@MethodSource
	void split(final String input, final String[] expected) {
		// given
		final String delimiter = ",";

		// when
		final String[] result = input.split(delimiter);

		// then
		assertThat(result).isEqualTo(expected);
		stream(expected).forEach(e -> assertThat(result).contains(e));
	}

	private static Stream<Arguments> substring() {
		return Stream.of(
			Arguments.of("(1,2)", "1,2")
		);
	}

	@DisplayName("[요구사항2] substring")
	@ParameterizedTest
	@MethodSource
	void substring(final String input, final String expected) {
		// given
		final String beginDelimeter = "(";
		final String endDelimiter = ")";

		final int beginIndex = input.indexOf(beginDelimeter) + 1;
		final int endIndex = input.indexOf(endDelimiter);

		// when
		final String result = input.substring(beginIndex, endIndex);

		// then
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("[요구사항3] charAt")
	@ParameterizedTest
	@CsvSource(value = {
		"abc,0,a",
		"abc,1,b",
		"abc,2,c"})
	void charAt(final String input, final int index, final char expected) {
		// given

		// when
		assertThat(input.charAt(index)).isEqualTo(expected);

		// then

	}

	@DisplayName("[요구사항3] charAt - IndexOutOfBoundsException")
	@Test
	void charAt_IndexOutOfBoundsException() {
		// given
		final String input = "abc";
		final int index = input.length();

		// when
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
			.isThrownBy(() -> input.charAt(index));

		// then

	}
}
