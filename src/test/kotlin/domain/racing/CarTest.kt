package domain.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @DisplayName("4이상이 들어오면 차는 움직인다")
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun moveTest(moveNumber: Int) {
        val car = Car()

        car.move(moveNumber)

        assertThat(car.getPosition()).isEqualTo(1)
    }

    @DisplayName("4미만이 들어오면 차는 안움직인다")
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun notMoveTest(moveNumber: Int) {
        val car = Car()

        car.move(moveNumber)

        assertThat(car.getPosition()).isEqualTo(0)
    }
}
