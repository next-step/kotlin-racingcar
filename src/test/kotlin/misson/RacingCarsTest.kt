package misson

import misson.car.domain.RacingCar
import misson.car.domain.RacingCars
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RacingCarsTest {
    @Test
    fun `자동차 그룹을 한번에 이동시킨다`() {
        val racingCars = RacingCars(List(3) { RacingCar() })
        racingCars.moveAll { 4 }

        racingCars.cars.forEach {
            assertThat(it.position).isEqualTo(1)
        }
    }

    @Test
    fun `자동차 그룹을 값이 4이하 이면 이동하지 않는다`() {
        val racingCars = RacingCars(List(3) { RacingCar() })
        racingCars.moveAll { 3 }

        racingCars.cars.forEach {
            assertThat(it.position).isEqualTo(1)
        }
    }

    @Test
    fun `가장 멀리간 자동차가 우승한다`() {
        val racingCars =
            RacingCars(
                listOf(
                    RacingCar("car1", 3),
                    RacingCar("car2", 2),
                    RacingCar("car3", 1),
                ),
            )

        val winners = racingCars.findWinners()
        assertThat(winners.getNames()).containsExactly("car1")
    }

    @Test
    fun `postion이 여러차가 동일 할 시에 공동 우승한다`() {
        val racingCars =
            RacingCars(
                listOf(
                    RacingCar("car1", 3),
                    RacingCar("car2", 3),
                    RacingCar("car3", 2),
                ),
            )

        val winners = racingCars.findWinners()
        assertThat(winners.getNames()).containsExactly("car1", "car2")
    }

    @ParameterizedTest
    @CsvSource(
        "4, 1",
        "5, 1",
        "3, 0",
        "2, 0",
    )
    fun `Param 값에 따라 자동차 그룹이 이동한다`(
        randomValue: Int,
        expectedPosition: Int,
    ) {
        val racingCars = RacingCars(List(3) { RacingCar() })
        racingCars.moveAll { randomValue }

        racingCars.cars.forEach { car ->
            assertThat(car.position).isEqualTo(expectedPosition)
        }
    }
}
