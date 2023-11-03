package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarMoveConditionTest {
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `숫자가 4 이상인 경우 이동할 수 있다`(number: Int) {
        val condition = CarMoveCondition { number }

        val actual = condition.canForward()

        assertThat(actual).isTrue
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `숫자가 4 미만인 경우 이동할 수 없다`(number: Int) {
        val condition = CarMoveCondition { number }

        val actual = condition.canForward()

        assertThat(actual).isFalse
    }
}
