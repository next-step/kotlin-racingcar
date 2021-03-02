package racingcar_winner

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar_winner.model.Car

class CarTest {

    val car = Car("Test")

    @ParameterizedTest
    @ValueSource(ints = [5, 6, 7, 8, 9])
    fun `차가 움직일때`(randomNumber: Int) {
        car.tryToMoveForward(randomNumber)
        assertThat(car.progress).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4])
    fun `차가 움직이지 않을때`(randomNumber: Int) {
        car.tryToMoveForward(randomNumber)
        assertThat(car.progress).isEqualTo(0)
    }
}