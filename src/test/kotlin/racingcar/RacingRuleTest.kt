package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingRuleTest {

    @Test
    fun `Cars 가 들어오면 우승자를 가려낼 수 있다`() {
        val cars = Cars(listOf(Car("aa", 2), Car("a", 1)), FixedPowerGenerator(5))

        val result = RacingRule.findWinners(cars)

        assertThat(result).usingRecursiveComparison().isEqualTo(listOf(Car("aa", 2)))
    }
}
