package racingCar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `이동 전략에 따라 자동차가 움직입니다`() {
        val cars = Cars(listOf(CarName("pobi"), CarName("crong"), CarName("kcs"))) { true }

        cars.moveByStrategy()

        assertThat(cars.cars).containsValues(Car.from(2), Car.from(2), Car.from(2))
    }

    @Test
    fun `한명 이상의 우승자가 선출되었습니다`() {
        val cars = Cars(listOf(CarName("pobi"), CarName("crong"), CarName("kcs"))) { true }
        cars.cars.get(CarName("pobi"))?.moveByStrategy({ true })
        cars.cars.get(CarName("crong"))?.moveByStrategy({ true })

        val winners = cars.findWinners()

        assertThat(winners).containsExactly(CarName("pobi"), CarName("crong"))
    }
}
