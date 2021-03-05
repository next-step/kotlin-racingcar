package study.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import study.racingcar.domain.Car
import study.racingcar.domain.Winner

internal class WinnerTest {

    @Test
    fun `1등이 3대 일경우 우승자의 수도 3`() {
        val winner = Winner()
        val car1 = Car("a")
        car1.moveCar()
        car1.moveCar()

        val car2 = Car("b")
        car2.moveCar()
        car2.moveCar()

        val car3 = Car("c")
        car3.moveCar()
        car3.moveCar()

        val cars: List<Car> = listOf(car1, car2, car3)
        val winners = winner.fetchWinners(cars)

        assertThat(winners.size).isEqualTo(3)
    }

    @Test
    fun `1등이 2대 일경우 우승자의 수도 2`() {
        val winner = Winner()
        val car1 = Car("a")
        car1.moveCar()
        car1.moveCar()

        val car2 = Car("b")
        car2.moveCar()
        car2.moveCar()

        val cars: List<Car> = listOf(car1, car2)
        val winners = winner.fetchWinners(cars)

        assertThat(winners.size).isEqualTo(2)
    }

    @Test
    fun `1등이 1대 일경우 우승자의 수도 1`() {
        val winner = Winner()
        val car1 = Car("a")
        car1.moveCar()
        car1.moveCar()

        val car2 = Car("b")
        car2.moveCar()

        val cars: List<Car> = listOf(car1, car2)
        val winners = winner.fetchWinners(cars)

        assertThat(winners.size).isEqualTo(1)
    }
}
