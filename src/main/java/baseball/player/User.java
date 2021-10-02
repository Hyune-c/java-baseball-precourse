package baseball.player;

import java.util.List;

import config.Property;

public class User extends Player {

	protected User(final List<Integer> numberList) {
		updateNumberList(numberList);
	}

	public static User of(final List<Integer> numberList) {
		return new User(numberList);
	}

	/**
	 * 기능 요구사항에 컴퓨터의 수는 서로 다른 3개의 수로 명시되어 있으나,
	 * 사용자의 수는 명시되어 있지 않아 수의 개수만 검증합니다.
	 *
	 * @return
	 */
	public boolean isValid() {
		return (getNumbers().size() == Property.NUMBER_SIZE);
	}
}
