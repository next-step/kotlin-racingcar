package racingcar.strategy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StrategyTest {

    private val strategy by lazy {
        RandomStrategy()
    }

    @Test
    fun `Is MovingStrategy move method always true?`() {
        repeat(1000) {
            assertThat(MovingStrategy().move(it)).isTrue()
        }
    }

    @Test
    fun `Is RandomStrategy generateNumber method return 0 - 9 number?`() {
        repeat(1000) {
            assertThat(strategy.generateNumber()).isBetween(0, 9)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [5, 6, 7, 8, 9])
    fun `RandomStrategy move method test greater than 4`(number: Int) {
        assertThat(strategy.move(number)).isTrue()
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 3, 2, 1, 0, -5])
    fun `RandomStrategy move method test less than 5`(number: Int) {
        assertThat(strategy.move(number)).isFalse()
    }
}
