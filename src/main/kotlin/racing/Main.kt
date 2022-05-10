package racing

import racing.model.CarMovingStrategy
import racing.model.Cars
import racing.view.InputView
import racing.view.ResultView

fun main() {
    InputView.printCarCountInputMessage()
    val carCount = InputView.inputCarCount()

    InputView.printTryCountInputMessage()
    val tryCount = InputView.inputTryCount()

    val cars = Cars.of(carCount)
    ResultView.printExecutionResultMessage()

    repeat(tryCount) {
        cars.moveForward(CarMovingStrategy)
        ResultView.printCarPositions(cars.cars)
    }
}
