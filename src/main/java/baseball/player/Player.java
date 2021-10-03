package baseball.player;

import java.util.List;
import java.util.Objects;

public abstract class Player {

	protected final List<Integer> numbers;

	protected Player(final List<Integer> numbers) {
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
