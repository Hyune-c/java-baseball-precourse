package baseball.player;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import exception.PlayerCreateException;

@DisplayName("유저의 수")
class UserTest {

	public static Stream<Arguments> create() {
		return Stream.of(
			Arguments.of(Arrays.asList(1, 2, 3)),
			Arguments.of(Arrays.asList(7, 8, 9))
		);
	}

	@DisplayName("생성")
	@ParameterizedTest
	@MethodSource
	void create(final List<Integer> input) {
		// given

		// when
		final User user = User.of(input);

		// then
		assertThat(user.getNumbers()).isEqualTo(input);
	}

	public static Stream<Arguments> create_invalid() {
		return Stream.of(
			Arguments.of(Arrays.asList(7, 8)),
			Arguments.of(Arrays.asList(0, 1, 2))
		);
	}

	@DisplayName("생성 - 유효하지 않은 초기 값")
	@ParameterizedTest
	@MethodSource
	void create_invalid(final List<Integer> input) {
		// given

		// when
		assertThatExceptionOfType(PlayerCreateException.class)
			.isThrownBy(() -> User.of(input));

		// then

	}
}
