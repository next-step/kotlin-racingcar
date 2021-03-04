package racingcar_winner

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar_winner.model.Car

class CarTest {

    val car = Car.makeCar("Test")

    @ParameterizedTest
    @ValueSource(ints = [5, 6, 7, 8, 9])
    fun `랜덤 숫자가 4보다 클때 차의 Progress가 증가하는지 확인`(randomNumber: Int) {
        car.tryToMoveForward(randomNumber)
        assertThat(car.progress).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4])
    fun `랜덤 숫자가 4보다 작을때 차의 Progress가 증가하는지 확인`(randomNumber: Int) {
        car.tryToMoveForward(randomNumber)
        assertThat(car.progress).isEqualTo(0)
    }
}