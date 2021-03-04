package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {

    @ParameterizedTest(name = "숫자가 {0}일 경우")
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `이동 4보다 크거나 같을 때`(value: Int) {
        val car = Car()
        val movedCar = car.move(value)
        assertThat(car.distance).isNotEqualTo(movedCar.distance)
    }

    @ParameterizedTest(name = "숫자가 {0}일 경우")
    @ValueSource(ints = [0, 1, 2, 3])
    fun `이동 숫자가 4보다 작을 때`(value: Int) {
        val car = Car()
        val movedCar = car.move(value)
        assertThat(car.distance).isEqualTo(movedCar.distance)
    }
}
