package baseball.player;

import static config.Property.*;
import static org.assertj.core.api.Assertions.*;
import static type.PitchingResultType.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import type.PitchingResultType;

@DisplayName("컴퓨터의 수")
class ComputerTest {

	@DisplayName("생성")
	@RepeatedTest(10)
	void create() {
		// given

		// when
		final Computer computer = Computer.of(NUMBER_LENGTH);

		// then
		final List<Integer> numbers = computer.getNumbers();

		assertThat(numbers.size()).isEqualTo(NUMBER_LENGTH);
		assertThat(!numbers.get(0).equals(numbers.get(1))
			&& !numbers.get(1).equals(numbers.get(2))).isTrue();
	}

	public static Stream<Arguments> checkNumber() {
		return Stream.of(
			Arguments.of(1, 0, STRIKE),
			Arguments.of(1, 1, BALL),
			Arguments.of(1, 2, BALL),
			Arguments.of(3, 0, BALL),
			Arguments.of(3, 1, BALL),
			Arguments.of(3, 2, STRIKE)
		);
	}

	@DisplayName("투구 결과 확인")
	@ParameterizedTest
	@MethodSource
	void checkNumber(final int number, final int position, final PitchingResultType expected) {
		// given
		final Computer computer = Computer.of(Arrays.asList(1, 2, 3));

		// when
		final PitchingResultType result = computer.checkNumber(number, position);

		// then
		assertThat(result).isEqualTo(expected);
	}
}
