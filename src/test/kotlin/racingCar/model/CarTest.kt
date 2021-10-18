package racingCar.model

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @Test
    fun `4 이상 움직이면 차가 움직인다`() {
        // given
        val car = Car("flamm")
        // when
        car.move(4)
        // then
        assertThat(car.mileage).isEqualTo(1)
    }

    @Test
    fun `4 아래로 움직이면 차는 움직이지 않는다`() {
        // given
        val car = Car("flamm")
        // when
        car.move(3)
        // then
        assertThat(car.mileage).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["ffffffff", "flammmmeeeee", "eeeeeeeeeee"])
    fun `자동차 이름이 지정 된 글자가 넘으면 에러처리`(input: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Car("flammeeee") }
            .withMessageContaining("자를 초과할 수 없습니다.")
    }
}
