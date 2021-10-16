package racingcar

class RacingGame(
    inputView: InputView,
    private val resultView: ResultView,
    private val carMoveForwardStrategy: CarMoveForwardDecider
) {
    private val numberOfCars: NumberOfCars = inputView.getNumberOfCars()
    private val numberOfTrials: NumberOfTrials = inputView.getNumberOfTrials()
    private val cars = Cars(numberOfCars)

    fun proceed() {
        resultView.showTitle()
        repeat(numberOfTrials.value!!) {
            cars.goForward(carMoveForwardStrategy)
            resultView.showStatuses(cars)
        }
    }
}
