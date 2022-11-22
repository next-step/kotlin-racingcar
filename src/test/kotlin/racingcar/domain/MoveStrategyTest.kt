package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class MoveStrategyTest {

    @DisplayName("0 ~ 3 범위의 수 테스트")
    @ParameterizedTest(name = "4미만의 값({0})는 전진할 수 없다")
    @ValueSource(ints = [0, 1, 2, 3])
    fun `4보다 작은 수는 멈춘다`(input: Int) {
        assertThat(MoveStrategy().canMove(input)).isEqualTo(false)
    }

    @DisplayName("4 ~ 9 범위의 수 테스트")
    @ParameterizedTest(name = "4미만의 값({0})는 전진할 수 있다")
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `4이상의 수는 전진할 수 있다`(input: Int) {
        assertThat(MoveStrategy().canMove(input)).isEqualTo(true)
    }
}
