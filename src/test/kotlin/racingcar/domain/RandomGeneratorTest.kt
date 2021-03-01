package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RandomGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 99])
    fun `from과 to가 같은 숫자인 경우 해당 숫자를 만들어낸다`(value: Int) {
        val randomGenerator = RandomGenerator(from = value, to = value)
        val result = randomGenerator.makeRandomValue()
        assertThat(result).isEqualTo(value)
    }

    @Test
    fun `randomGenerator의 범위는 경계를 포함한다`() {
        val from = 1
        val to = 2
        val randomGenerator = RandomGenerator(from = from, to = to)
        val expected = listOf(1, 2)

        // 2^100 번에 한번꼴로 테스트가 실패할 수 있다
        val result = (1..100).map { randomGenerator.makeRandomValue() }.distinct()

        assertThat(result).containsAll(expected)
    }
}
