package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    private val registerCarNames = "자동차1,자동차2,자동차3,자동차4,자동차5"

    @Test
    fun `차량 생성 수 확인`() {

        // when
        val cars = Cars(registerCarNames)

        // then
        assertThat(cars.cars.size).isEqualTo(5)
    }

    @Test
    fun `차량 이동 확인`() {

        // given
        val cars = Cars(registerCarNames)

        // when
        cars.moveOfCars { true }

        // then
        cars.cars.forEach {
            assertThat(it.carPosition()).isEqualTo(1)
        }
    }
}
