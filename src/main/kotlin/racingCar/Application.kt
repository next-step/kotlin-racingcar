package racingCar

import racingCar.controller.RacingGame
import racingCar.model.Cars
import racingCar.view.InputView
import racingCar.view.OutputView

fun main() {
    val carName = InputView.inputCarNames().split(",")
    val amountOfRound = InputView.inputAmountOfRound()
    val cars = Cars(carName)

    OutputView.showResultMessage()

    repeat(amountOfRound) {
        RacingGame.playGame(cars)
        OutputView.showResult(cars)
    }

    val winner = cars.findWinners()
    OutputView.showWinners(winner)
}
