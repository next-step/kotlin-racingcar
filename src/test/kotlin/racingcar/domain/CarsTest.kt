package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `차량 생성 수 확인`() {
        // given
        val registerCarNumber = 5

        // when
        val cars = Cars(registerCarNumber)

        // then
        assertThat(cars.cars.size).isEqualTo(5)
    }

    @Test
    fun `차량 이동 확인`() {
        // given
        val registerCarNumber = 5
        val cars = Cars(registerCarNumber)

        // when
        cars.moveOfCars(true)

        // then
        cars.cars.forEach {
            assertThat(it.carPosition()).isEqualTo(1)
        }
    }
}
