package baseball.player;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("컴퓨터의 수")
class ComputerTest {

	@DisplayName("[성공] 생성")
	@RepeatedTest(10)
	void success_create() {
		// given
		final int size = 3;

		// when
		final Computer computer = Computer.of(size);

		// then
		final List<Integer> numbers = computer.getNumbers();
		assertThat(numbers.size()).isEqualTo(size);
		assertThat(!numbers.get(0).equals(numbers.get(1))
			&& !numbers.get(1).equals(numbers.get(2))).isTrue();

		System.out.printf("### %d, %d, %d%n", numbers.get(0), numbers.get(1), numbers.get(2));
	}
}
