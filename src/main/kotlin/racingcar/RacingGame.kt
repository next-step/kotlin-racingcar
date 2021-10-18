package racingcar

import racingcar.domain.Cars
import racingcar.service.CarMoveForwardDecider

class RacingGame(
    inputView: InputView,
    private val resultView: ResultView,
    private val carMoveForwardDecider: CarMoveForwardDecider
) {
    private val numberOfCars: NumberOfCars = inputView.getNumberOfCars()
    private val numberOfTrials: NumberOfTrials = inputView.getNumberOfTrials()
    private val cars = Cars.from(numberOfCars)

    fun proceed() {
        resultView.showTitle()
        repeat(numberOfTrials.value) {
            cars.goForward(carMoveForwardDecider)
            resultView.showStatuses(cars)
        }
    }
}
