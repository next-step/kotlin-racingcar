package racing.v2

import racing.v2.domain.Car
import racing.v2.domain.CarGame
import racing.v2.domain.CarGameRandomGenerator
import racing.v2.view.InputView
import racing.v2.view.ResultView

fun main() {
    val carsStr: String = requestCars()
    val tryCount: Int = requestTryCount()

    ResultView.printResultStart()
    val carGame = playGame(Car.ofList(carsStr), tryCount)
    ResultView.printWinner(carGame.findWinners())
}

private fun requestCars(): String {
    InputView.printCarNamesPrompt()
    val carsStr = InputView.getUserInput()
    return InputView.validateCars(carsStr)
}

private fun requestTryCount(): Int {
    InputView.printTryCountPrompt()
    val tryCountStr = InputView.getUserInput()
    return InputView.validateTryCount(tryCountStr)
}

private fun playGame(
    cars: List<Car>,
    tryCount: Int
): CarGame {
    val carGame = CarGame(cars, tryCount, CarGameRandomGenerator)

    while (carGame.hasMoreRounds()) {
        carGame.startRound()
        ResultView.printCarPosition(cars)
    }

    return carGame
}
