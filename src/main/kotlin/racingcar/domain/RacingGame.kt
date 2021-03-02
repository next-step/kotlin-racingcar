package racingcar.domain

import racingcar.domain.CarConfig.randomNumberGenerator
import racingcar.ui.OutputView

class RacingGame(private val tryCount: Int, private val numberOfCar: Int) {

    private val carCollection = CarCollection(numberOfCar)

    fun runRace() {
        OutputView.printOutputLetter()
        for (i in 1..tryCount) {
            carCollection.tryMoveCars(randomNumberGenerator(numberOfCar))
            OutputView.printCarCollection(carCollection.getCarsPosition())
        }
    }
}
