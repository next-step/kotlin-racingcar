package racingcar.domain

import racingcar.domain.CarConfig.randomNumberGenerator
import racingcar.history.RacingRoundHistory

class RacingGame(private val tryCount: Int, private val numberOfCar: Int) {

    private val carCollection = CarCollection(numberOfCar)

    fun runRace(): List<RacingRoundHistory> {
        repeat(tryCount) {
            carCollection.tryMoveCars(round = it, conditionNumbers = randomNumberGenerator(numberOfCar))
        }
        return carCollection.getRacingHistories()
    }
}
