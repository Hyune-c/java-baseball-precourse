package baseball.player;

import static config.Property.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("컴퓨터의 수")
class ComputerTest {

	@DisplayName("생성")
	@RepeatedTest(10)
	void create() {
		// given

		// when
		final Computer computer = Computer.of(NUMBER_SIZE);

		// then
		final List<Integer> numbers = computer.getNumbers();

		assertThat(numbers.size()).isEqualTo(NUMBER_SIZE);
		assertThat(!numbers.get(0).equals(numbers.get(1))
			&& !numbers.get(1).equals(numbers.get(2))).isTrue();
	}
}
