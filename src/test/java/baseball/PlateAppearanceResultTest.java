package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import baseball.player.Computer;
import baseball.player.User;
import type.PitchingResultType;

@DisplayName("타석 결과")
class PlateAppearanceResultTest {

	@DisplayName("[성공] 생성")
	@RepeatedTest(10)
	void success_create() {
		// given
		final int size = 3;
		final Computer computer = Computer.of(size);
		final Random random = new Random();
		final List<Integer> inputList = Arrays.asList(
			random.nextInt(9) + 1,
			random.nextInt(9) + 1,
			random.nextInt(9) + 1);
		final User user = User.of(inputList);

		// when
		final PlateAppearanceResult plateAppearanceResult = new PlateAppearanceResult(computer, user);

		// then
		int pitchingCount = 0;
		for (final PitchingResultType pitchingResultType : PitchingResultType.values()) {
			pitchingCount += plateAppearanceResult.count(pitchingResultType);
		}

		assertThat(pitchingCount).isEqualTo(size);

		System.out.printf("### %s\n", inputList);
		for (final PitchingResultType pitchingResultType : PitchingResultType.values()) {
			System.out.printf("%s ", pitchingResultType.name());
		}
		System.out.println();
	}
}
