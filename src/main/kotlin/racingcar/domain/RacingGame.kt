package racingcar.domain

import racingcar.domain.CarConfig.randomNumberGenerator
import racingcar.ui.OutputView

class RacingGame(private val tryCount: Int, private val numberOfCar: Int) {

    private val carCollection = CarCollection(numberOfCar)

    fun runRace() {
        OutputView.printOutputLetter()
        repeat(tryCount) {
            carCollection.tryMoveCars(randomNumberGenerator(numberOfCar))
            OutputView.printCarCollection(carCollection.getCarsPosition())
        }
        println()
    }
}
