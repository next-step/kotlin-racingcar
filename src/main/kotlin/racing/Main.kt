package racing

import racing.model.CarMovingStrategy
import racing.model.Cars
import racing.view.InputView
import racing.view.ResultView

fun main() {
    InputView.printCarNamesInputMessage()
    val carNames = InputView.inputCarNames()

    InputView.printTryCountInputMessage()
    val tryCount = InputView.inputTryCount()

    val cars = Cars.of(carNames)
    ResultView.printExecutionResultMessage()

    repeat(tryCount) {
        cars.moveForward(CarMovingStrategy)
        ResultView.printCarPositions(cars.cars)
    }

    ResultView.printWinnerNames(cars.findWinners())
}
