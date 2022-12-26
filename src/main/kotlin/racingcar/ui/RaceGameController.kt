package racingcar.ui

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.Race
import racingcar.domain.RaceResult
import racingcar.domain.strategy.RandomMovableStrategy

object RaceGameController {
    fun readyForRace(carNames: List<String>, totalRound: Int): Race {
        val cars = Cars(carNames.map { Car(it) })

        return Race(cars, totalRound)
    }

    fun runRace(race: Race): RaceResult {
        return race.run(RandomMovableStrategy())
    }

    fun findWinner(raceResult: RaceResult): List<Car> {
        return raceResult.getFinalRoundWinners()
    }
}
