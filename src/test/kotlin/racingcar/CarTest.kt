package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun runOneCarTest(prevScore: Int) {
        // given
        val car = Car()
        car.score = prevScore
        val canMove = true

        // when
        car.move(canMove)

        // then
        assertThat(car.score).isEqualTo(prevScore + 1)
    }
}
