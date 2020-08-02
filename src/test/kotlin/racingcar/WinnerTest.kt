package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.RacingGame
import racingcar.model.Winner

class WinnerTest {

    @Test
    fun `우승자가 한 명인 경우`() {
        val cars = listOf(Car("1st"), Car("2nd"), Car("3rd"))
        val racingGame = RacingGame(racingCars = cars)
        val winner = Winner(racingGame)

        cars[0].move(4)

        assertThat(winner.find()).isEqualTo(cars[0].name)
    }

    @Test
    fun `우승자가 여러 명인 경우`() {
        val cars = listOf(Car("1st"), Car("2nd"), Car("best"))
        val racingGame = RacingGame(racingCars = cars)
        val winner = Winner(racingGame)

        cars[0].move(4)
        cars[2].move(4)

        assertThat(winner.find()).isEqualTo(listOf(cars[0].name, cars[2].name).joinToString())
    }
}
