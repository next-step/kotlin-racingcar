package racingCar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    private val car = Car()

    @DisplayName(value = "입력된 숫자가 4 이상이면 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8])
    fun `car move`(number: Int) {
        car.move(number)
        assertThat(car.distance).isEqualTo(1)
    }

    @DisplayName(value = "입력된 숫자가 4 보다 작면 움직이지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `car not move`(number: Int) {
        car.move(number)
        assertThat(car.distance).isEqualTo(0)
    }
}
