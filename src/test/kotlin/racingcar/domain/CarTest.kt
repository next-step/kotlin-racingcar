package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.service.CarMoveForwardDecider
import racingcar.service.CarMoveForwardFixedValueGetter

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `자동차 전진 테스트`(value: Int) {
        val car = Car(CarName.from("ninja"))
        val originalPosition = car.position

        car.moveForward(CarMoveForwardDecider(CarMoveForwardFixedValueGetter(value)))

        assertThat(car.position).isEqualTo(originalPosition + 1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `자동차 전진 불가 테스트`(value: Int) {
        val car = Car(CarName.from("ninja"))
        val originalPosition = car.position

        car.moveForward(CarMoveForwardDecider(CarMoveForwardFixedValueGetter(value)))

        assertThat(car.position).isEqualTo(originalPosition)
    }
}
