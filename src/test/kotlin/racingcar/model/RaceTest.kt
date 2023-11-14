package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RaceTest {

    @Test
    fun `경주가 끝나기 전에 결과를 얻으려고 하면 에러를 반환한다`() {
        val cars = CarsFactory.createCars(TrueEngineCarCreator(), listOf(CarName("a"), CarName("b")))
        val race = Race(1, cars)

        assertThrows<IllegalStateException> {
            race.getRoundResults()
        }
    }

    @Test
    fun `경주가 끝나기 전에 우승자를 얻으려고 하면 에러를 반환한다`() {
        val cars = CarsFactory.createCars(TrueEngineCarCreator(), listOf(CarName("a"), CarName("b")))
        val race = Race(1, cars)

        assertThrows<IllegalStateException> {
            race.getWinners()
        }
    }

    @Test
    fun `경주가 끝나면 우승자를 반환한다`() {
        val cars = CarsFactory.createCars(TrueEngineCarCreator(), listOf(CarName("a"), CarName("b")))
        val race = Race(1, cars)
        race.start()

        val winners = race.getWinners()

        assertThat(winners).hasSize(2)
        assertThat(winners).containsExactlyInAnyOrder(cars.cars[0], cars.cars[1])
    }

    @Test
    fun `경주가 끝나면 경주 결과를 반환한다`() {
        val cars = CarsFactory.createCars(TrueEngineCarCreator(), listOf(CarName("a"), CarName("b")))
        val race = Race(1, cars)
        race.start()

        val roundResults = race.getRoundResults()

        assertThat(roundResults).hasSize(1)
        assertThat(roundResults).containsExactly(
            RoundResults.RoundResult(1, listOf(RoundResults.CarMoveResult("a", 1), RoundResults.CarMoveResult("b", 1))),
        )
    }
}
