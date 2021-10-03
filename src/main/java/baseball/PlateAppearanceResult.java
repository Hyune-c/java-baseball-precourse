package baseball;

import static type.PitchingResultType.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import baseball.player.Computer;
import baseball.player.User;
import type.PitchingResultType;

public class PlateAppearanceResult {

	private static final String NOTHING = "낫싱";

	private final Map<PitchingResultType, Integer> pitchingResultMap = new HashMap<>();

	public PlateAppearanceResult(final Computer computer, final User user) {
		final List<Integer> userNumberList = user.getNumbers();
		for (int i = 0; i < userNumberList.size(); i++) {
			final PitchingResultType pitchingResult = computer.checkNumber(userNumberList.get(i), i);
			this.pitchingResultMap.put(pitchingResult, count(pitchingResult) + 1);
		}
	}

	public int count(final PitchingResultType pitchingResultType) {
		return pitchingResultMap.getOrDefault(pitchingResultType, 0);
	}

	public boolean isAllStrike() {
		return (count(STRIKE) == 3);
	}

	public String generateMessage() {
		if (count(OUT) == 3) {
			return NOTHING;
		}

		return STRIKE.message(count(STRIKE)) + BALL.message(count(BALL));
	}
}
