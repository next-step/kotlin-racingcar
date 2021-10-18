package racingcar

class RacingGame(
    inputView: InputView,
    private val resultView: ResultView,
    carMoveForwardStrategy: CarMoveForwardDecider
) {
    private val numberOfCars: NumberOfCars = inputView.getNumberOfCars()
    private val numberOfTrials: NumberOfTrials = inputView.getNumberOfTrials()
    private val cars = Cars(numberOfCars, carMoveForwardStrategy)

    fun proceed() {
        resultView.showTitle()
        repeat(numberOfTrials.value) {
            cars.goForward()
            resultView.showStatuses(cars)
        }
    }
}
