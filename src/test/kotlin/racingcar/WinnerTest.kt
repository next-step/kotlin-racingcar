package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.RacingGame
import racingcar.model.Winner

class WinnerTest {

    private lateinit var cars: List<Car>
    private lateinit var racingGame: RacingGame
    private lateinit var winner: Winner

    @BeforeEach
    fun setup() {
        cars = listOf(Car("one"), Car("two"), Car("three"))
        racingGame = RacingGame(racingCars = cars)
        winner = Winner(racingGame)
    }

    @Test
    fun `우승자가 한 명인 경우`() {
        cars[0].move(4)

        assertThat(winner.find()).isEqualTo(cars[0].name)
    }

    @Test
    fun `우승자가 여러 명인 경우`() {
        repeat(2) {
            cars[it].move(4)
        }

        assertThat(winner.find().split(",").size).isEqualTo(2)
    }
}
