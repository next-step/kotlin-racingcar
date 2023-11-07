package racingcar

import racingcar.controller.RacingCarController
import racingcar.domain.Car
import racingcar.domain.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carNames = InputView.inputCarNames()
    val countOfTry = InputView.inputCountOfTry()

    val cars = carNames.map {
        Car(it)
    }

    ResultView.printInit()
    ResultView.printResult(RacingCarController(countOfTry, RacingGame(cars)).start())
}
