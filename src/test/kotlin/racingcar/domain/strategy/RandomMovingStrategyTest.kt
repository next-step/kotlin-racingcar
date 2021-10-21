package racingcar.domain.strategy

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RandomMovingStrategyTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `0이상 3이하의 숫자가 나오면 이동할 수 없다`(value: Int) {
        assertThat(MockRandomMovingStrategy(value).movable()).isFalse
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `4이상의 숫자가 나오면 이동할 수 있다`(value: Int) {
        assertThat(MockRandomMovingStrategy(value).movable()).isTrue
    }
}
