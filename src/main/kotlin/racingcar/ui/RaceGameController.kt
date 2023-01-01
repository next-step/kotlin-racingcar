package racingcar.ui

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.Race
import racingcar.domain.RaceResult

object RaceGameController {
    fun readyForRace(carNames: List<String>, totalRound: Int): Race {
        val cars = Cars(carNames.map { Car(it) })

        return Race(cars, totalRound)
    }

    fun runRace(race: Race): RaceResult {
        return race.run(movableStrategy = { RANDOM_NUMBER_RANGE.random() >= MOVABLE_CONDITION_NUMBER })
    }

    fun findWinner(raceResult: RaceResult): List<Car> {
        return raceResult.getFinalRoundWinners()
    }

    private const val MOVABLE_CONDITION_NUMBER = 4
    private val RANDOM_NUMBER_RANGE = 0..9
}
