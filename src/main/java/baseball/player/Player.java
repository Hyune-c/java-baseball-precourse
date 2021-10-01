package baseball.player;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class Player {

	private List<Integer> numberList;

	public void updateNumberList(final List<Integer> newNumberList) {
		this.numberList = Collections.unmodifiableList(newNumberList);
	}

	public List<Integer> getNumberList() {
		return numberList;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Player))
			return false;
		final Player player = (Player)o;
		return Objects.equals(getNumberList(), player.getNumberList());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNumberList());
	}
}
