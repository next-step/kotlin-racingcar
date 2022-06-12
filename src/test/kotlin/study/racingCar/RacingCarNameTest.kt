package study.racingCar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import study.racingCar.domain.Car

class RacingCarNameTest {

    @Test
    fun `자동차 이름이 5글자 이하만 허용된다`() {
        val car = Car("55555")
        Assertions.assertThat(car.carName).isEqualTo("55555")
    }

    @Test
    fun `자동차 이름이 5글자를 초과할 수 없다`() {
        Assertions.assertThatThrownBy {
            val car = Car("666666")
        }.isInstanceOf(java.lang.IllegalArgumentException::class.java)
    }
}
