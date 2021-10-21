package racingCar.model

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
        car.move(TestCarMovement() { FORWARD_MOVE })
        val mileage = car.info().second

        // then
        assertThat(mileage).isEqualTo(FORWARD_SUCCESS)
    }

    @Test
    fun `4 아래로 움직이면 차는 움직이지 않는다`() {
        // given
        val car = Car("flamm")
        // when
        car.move(TestCarMovement() { STOP })
        val mileage = car.info().second
        // then
        assertThat(mileage).isEqualTo(STOP_SUCCESS)
    }

    @ParameterizedTest
    @ValueSource(strings = ["ffffffff", "flammmmeeeee", "eeeeeeeeeee"])
    fun `자동차 이름이 지정 된 글자가 넘으면 에러처리`(input: String) {
        // when
        val nameException = runCatching { Car(input) }.exceptionOrNull()
        // then
        assertThat(nameException).hasMessage("자동차 이름은 5 자를 초과할 수 없습니다.")
    }

    companion object {
        private const val FORWARD_MOVE = 4
        private const val STOP = 1
        private const val FORWARD_SUCCESS = 1
        private const val STOP_SUCCESS = 0
    }
}
