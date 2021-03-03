package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RandomMoveStrategyTest {

    @ParameterizedTest
    @CsvSource(
        "1, 1, true",
        "2, 1, true",
        "1, 2, false"
    )
    fun `threshold 가 랜덤값보다 크거나 같은 경우 움직일 수 있다`(threshold: Int, value: Int, expected: Boolean) {
        // given
        val valueGenerator = RandomGenerator(from = value, to = value)
        val randomMoveStrategy = RandomMoveStrategy(randomGenerator = valueGenerator, threshold = threshold)

        // when
        val result = randomMoveStrategy.isMoveable()

        // then
        assertThat(result).isEqualTo(expected)
    }
}
