package baseball;

import static config.Property.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import baseball.player.Computer;
import baseball.player.User;
import nextstep.utils.Randoms;
import type.PitchingResultType;

@DisplayName("타석 결과")
class PlateAppearanceResultTest {

	@DisplayName("생성")
	@RepeatedTest(10)
	void create() {
		// given
		final int size = NUMBER_LENGTH;
		final Computer computer = Computer.of(size);
		final List<Integer> inputList = Arrays.asList(
			Randoms.pickNumberInRange(1, 9),
			Randoms.pickNumberInRange(1, 9),
			Randoms.pickNumberInRange(1, 9));
		final User user = User.of(inputList);

		// when
		final PlateAppearanceResult plateAppearanceResult = new PlateAppearanceResult(computer, user);

		// then
		System.out.printf("### computer=%s\n", computer.getNumbers());
		System.out.printf("###     user=%s\n", inputList);
		Arrays.stream(PitchingResultType.values())
			.forEach(e -> System.out.printf("%d%s ", plateAppearanceResult.count(e), e.name()));
		System.out.println();

		final int pitchingCount = Arrays.stream(PitchingResultType.values())
			.map(plateAppearanceResult::count)
			.reduce(0, Integer::sum);
		assertThat(pitchingCount).isEqualTo(size);
	}
}
