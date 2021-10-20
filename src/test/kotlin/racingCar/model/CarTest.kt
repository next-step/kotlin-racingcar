package racingCar.model

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @Test
    fun `자동차를 만들어본다`() {
        // given
        val car = Car("flamm")

        // when
        val (carName, mileage) = car.info()

        // then
        assertAll(
            { assertThat(carName).isEqualTo("flamm") },
            { assertThat(mileage).isEqualTo(0) }
        )
    }

    @Test
    fun `4 이상 움직이면 차가 움직인다`() {
        // given
        val car = Car("flamm")

        // when
        car.move(CarMoveAmount(5))
        val mileage = car.info().second

        // then
        assertThat(mileage).isEqualTo(1)
    }

    @Test
    fun `4 아래로 움직이면 차는 움직이지 않는다`() {
        // given
        val car = Car("flamm")
        // when
        car.move(CarMoveAmount(3))
        val mileage = car.info().second
        // then
        assertThat(mileage).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["ffffffff", "flammmmeeeee", "eeeeeeeeeee"])
    fun `자동차 이름이 지정 된 글자가 넘으면 에러처리`(input: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Car(input) }
            .withMessageContaining("자를 초과할 수 없습니다.")
    }
}
