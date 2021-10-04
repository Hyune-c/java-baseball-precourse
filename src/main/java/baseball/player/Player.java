package baseball.player;

import java.util.List;
import java.util.Objects;

import exception.PlayerCreateException;

public abstract class Player {

	protected static final int MIN_NUMBER = 1;
	protected static final int MAX_NUMBER = 9;

	protected final List<Integer> numbers;

	protected Player(final List<Integer> numbers) {
		if (numbers.stream().anyMatch(e -> e < MIN_NUMBER || e > MAX_NUMBER)) {
			throw new PlayerCreateException();
		}

		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Player))
			return false;
		final Player player = (Player)o;
		return Objects.equals(numbers, player.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}
}
