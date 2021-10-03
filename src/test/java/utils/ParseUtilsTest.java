package utils;

import static config.Property.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import baseball.exception.InputParseException;
import baseball.utils.ParseUtils;

@DisplayName("문자열 파싱")
class ParseUtilsTest {

	public static String[] possibleParsedString() {
		return new String[] {"123", "456", "150"};
	}

	@DisplayName("정의된 길이로 parse")
	@ParameterizedTest
	@MethodSource("possibleParsedString")
	void parse(final String input) {
		// given

		// when
		final List<Integer> result = ParseUtils.parse(input, NUMBER_LENGTH);

		// then
		assertThat(result.size()).isPositive();
	}

	public static String[] parse_invalid() {
		return new String[] {"", "   ", "-10", "hello", "java", "1", "12", "5555", "1234567"};
	}

	@DisplayName("정의된 길이로 parse - 유효하지 않은 초기 값")
	@ParameterizedTest
	@MethodSource
	void parse_invalid(final String input) {
		// given

		// when
		assertThatExceptionOfType(InputParseException.class)
			.isThrownBy(() -> ParseUtils.parse(input, NUMBER_LENGTH))
			.withMessage(new InputParseException().getMessage());

		// then

	}
}
