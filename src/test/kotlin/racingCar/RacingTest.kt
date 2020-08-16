package racingCar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingCar.domain.Car
import racingCar.domain.RacingCars

class RacingTest {

    @Test
    fun `우승자가 없을 경우`() {
        val car1 = Car("A")
        val car2 = Car("B")
        car1.changeStateRacingCar(1)
        car2.changeStateRacingCar(3)
        val carList = listOf(car1, car2)

        val winner = RacingCars().getRacingWinner(carList)

        Assertions.assertThat(winner).isEqualTo("")
    }

    @Test
    fun `우승자가 1명인 경우`() {
        val car1 = Car("A")
        val car2 = Car("B")
        car1.changeStateRacingCar(5)
        car2.changeStateRacingCar(3)
        val carList = listOf(car1, car2)

        val winner = RacingCars().getRacingWinner(carList)

        Assertions.assertThat(winner).isEqualTo("A")
    }

    @Test
    fun `우승자가 2명이상인 경우`() {
        val car1 = Car("A")
        val car2 = Car("B")
        car1.changeStateRacingCar(4)
        car2.changeStateRacingCar(4)
        val carList = listOf(car1, car2)

        val winner = RacingCars().getRacingWinner(carList)

        Assertions.assertThat(winner).isEqualTo("A, B")
    }
}
