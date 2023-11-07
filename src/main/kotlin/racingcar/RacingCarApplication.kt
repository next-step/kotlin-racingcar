package racingcar

import racingcar.controller.RacingCarController
import racingcar.domain.Car
import racingcar.domain.RacingGame
import racingcar.domain.Winner
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carNames = InputView.inputCarNames()
    val countOfTry = InputView.inputCountOfTry()

    val cars = carNames.map {
        Car(it)
    }

    val results = RacingCarController(countOfTry, RacingGame(cars)).start()

    ResultView.printInit()
    ResultView.printResult(results)
    ResultView.printWinners(Winner(results.last()).evaluate())
}
