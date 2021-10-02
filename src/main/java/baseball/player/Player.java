package baseball.player;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class Player {

	private List<Integer> numbers;

	public void updateNumberList(final List<Integer> newNumberList) {
		this.numbers = Collections.unmodifiableList(newNumberList);
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
		return Objects.equals(getNumbers(), player.getNumbers());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNumbers());
	}
}
