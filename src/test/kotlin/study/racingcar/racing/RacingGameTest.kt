package study.racingcar.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import study.racingcar.car.CarFactory

internal class RacingGameTest {
    @Test
    fun `RacingGame에서는 Race 전체 결과를 반환한다`() {
        val generator = AlwaysMoveGenerator()
        val cars = CarFactory.createCars(listOf("아반떼", "소나타"))
        val racingGame = RacingGame(cars, 2)

        val firstRace = cars.map { car ->
            Record(car.name, car.currentLocation + 1)
        }
        val secondRace = firstRace.map { result ->
            Record(result.name, result.location + 1)
        }

        assertThat(racingGame.run(generator)).isEqualTo(listOf(firstRace, secondRace))
    }

    @Test
    fun `RacingGame에서는 Race 종료 후 우승자를 출력한다`() {
        val generator = AlwaysMoveGenerator()
        val cars = CarFactory.createCars(listOf("아반떼", "소나타"))
        val racingGame = RacingGame(cars, 2)

        val firstRace = cars.map { car ->
            Record(car.name, car.currentLocation + 1)
        }
        val secondRace = firstRace.map { result ->
            Record(result.name, result.location + 1)
        }

        assertThat(racingGame.run(generator)).isEqualTo(RacingResult(listOf(firstRace, secondRace)))
    }
}
