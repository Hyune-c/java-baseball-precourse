package utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import baseball.utils.ParseUtils;

@DisplayName("문자열 파싱")
class ParseUtilsTest {

	public static String[] possibleParsedString() {
		return new String[] {"123", "456", "150"};
	}

	@DisplayName("[성공] 정의된 길이로 parse")
	@ParameterizedTest
	@MethodSource("possibleParsedString")
	void success_parse(final String input) {
		// given
		final int size = 3;

		// when
		final List<Integer> result = ParseUtils.parse(input, size);

		// then
		assertThat(result.size()).isPositive();
	}

	public static String[] impossibleParsedString() {
		return new String[] {"", "   ", "-10", "hello", "java"};
	}

	@DisplayName("[실패] 정의된 길이로 parse - 파싱할 수 없음")
	@ParameterizedTest
	@MethodSource("impossibleParsedString")
	void fail_parse_impossible(final String input) {
		// given
		final int size = 3;

		// when
		assertThrows(NumberFormatException.class, () -> ParseUtils.parse(input, size));

		// then
	}

	public static String[] IllegalLengthString() {
		return new String[] {"1", "12", "5555", "1234567"};
	}

	@DisplayName("[실패] 정의된 길이로 parse - 맞지 않는 길이")
	@ParameterizedTest
	@MethodSource("IllegalLengthString")
	void fail_parse_illegalLength(final String input) {
		// given
		final int size = 3;

		// when
		assertThrows(IllegalArgumentException.class, () -> ParseUtils.parse(input, size));

		// then
	}
}
