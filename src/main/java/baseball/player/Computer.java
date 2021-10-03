package baseball.player;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import nextstep.utils.Randoms;
import type.PitchingResultType;

public class Computer extends Player {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	protected Computer(final List<Integer> numbers) {
		super(numbers);
	}

	public static Computer of(final int numberSize) {
		return new Computer(generateRandomNumbers(numberSize));
	}

	public PitchingResultType checkNumber(final int number, final int position) {
		if (numbers.get(position) == number) {
			return PitchingResultType.STRIKE;
		}

		if (numbers.contains(number)) {
			return PitchingResultType.BALL;
		}

		return PitchingResultType.OUT;
	}

	private static List<Integer> generateRandomNumbers(final int numberSize) {
		final LinkedHashSet<Integer> newNumbers = new LinkedHashSet<>();
		while (newNumbers.size() < numberSize) {
			newNumbers.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
		}

		return new ArrayList<>(newNumbers);
	}
}
