package racingcar

import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputNumberOfCars = InputView.requestNumberOfCars()
    val inputNumberOfRounds = InputView.requestNumberOfRounds()

    val racingGame = RacingGame(inputNumberOfCars, inputNumberOfRounds)
    racingGame.start()

    OutputView.printResult(racingGame.getResult())
}
