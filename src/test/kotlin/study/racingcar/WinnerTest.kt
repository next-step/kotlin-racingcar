package study.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WinnerTest {

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
