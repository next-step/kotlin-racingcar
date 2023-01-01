package racingcar.ui

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.Race
import racingcar.ui.view.getCarNames
import racingcar.ui.view.getTotalRound
import racingcar.ui.view.printRaceResult

object RaceGameController {
    fun play() {
        val race = readyForRace()
        val raceResult = race.run(movableStrategy = {
            RANDOM_NUMBER_RANGE.random() >= MOVABLE_CONDITION_NUMBER
        })
        val raceWinners = raceResult.getFinalRoundWinners()

        printRaceResult(raceResult, raceWinners)
    }

    private fun readyForRace(): Race {
        val carNames = getCarNames()
        val cars = Cars(carNames.map { Car(it) })

        val totalRound = getTotalRound()

        return Race(cars, totalRound)
    }

    private const val MOVABLE_CONDITION_NUMBER = 4
    private val RANDOM_NUMBER_RANGE = 0..9
}
