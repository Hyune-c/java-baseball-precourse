package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("[요구사항1] size")
	@Test
	void size() {
		// given
		final int expected = 3;

		// when
		final int result = numbers.size();

		// then
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("[요구사항2] contains")
	@ParameterizedTest
	@ValueSource(ints = {
		1, 2, 3
	})
	void contains(final int element) {
		// given

		// when
		assertThat(numbers.contains(element)).isTrue();

		// then

	}

	@DisplayName("[요구사항3] contains - 포함되지 않은 element")
	@ParameterizedTest
	@CsvSource(value = {
		"1,true",
		"2,true",
		"3,true",
		"4,false",
		"5,false",})
	void contains(final int element, final boolean expected) {
		// given

		// when
		assertThat(numbers.contains(element)).isEqualTo(expected);

		// then

	}
}
