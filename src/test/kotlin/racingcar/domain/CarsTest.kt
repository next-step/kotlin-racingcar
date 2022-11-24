package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `이동 전략에 따라 자동차가 움직입니다`() {
        val cars = Cars.ofNames(listOf("pobi", "crong", "kcs")) { true }

        val movedCars = cars.moveByStrategy()

        assertThat(movedCars.cars).containsExactly(
            Car.withNameAndPosition("pobi", 1),
            Car.withNameAndPosition("crong", 1),
            Car.withNameAndPosition("kcs", 1)
        )
    }

    @Test
    fun `한명 이상의 우승자가 선출되었습니다`() {
        val cars = Cars.ofNames(listOf("pobi", "crong", "kcs")) { true }
        val movedCars = cars.moveByStrategy()

        val winners = movedCars.findWinners()

        assertThat(winners).containsExactly(
            Car.withNameAndPosition("pobi", 1),
            Car.withNameAndPosition("crong", 1),
            Car.withNameAndPosition("kcs", 1),
        )
    }
}
