package type;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("게임 상태")
class GameStatusTypeTest {

	public static String[] findByFlag() {
		return new String[] {"1", "2"};
	}

	@DisplayName("[성공] flag 로 enum 찾기")
	@ParameterizedTest
	@MethodSource
	void findByFlag(final String flagString) {
		// given
		final int flag = Integer.parseInt(flagString);

		// when
		final GameStatusType result = GameStatusType.findByFlag(flag);

		// then
		assertThat(result).isNotNull();
	}

	public static String[] findByFlag_invalid() {
		return new String[] {"0", "4", "5"};
	}

	@DisplayName("[실패] flag 로 enum 찾기 - 적절하지 않은 flag")
	@ParameterizedTest
	@MethodSource
	void findByFlag_invalid(final String flagString) {
		// given
		final int flag = Integer.parseInt(flagString);

		// when
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> GameStatusType.findByFlag(flag));

		// then
	}
}
