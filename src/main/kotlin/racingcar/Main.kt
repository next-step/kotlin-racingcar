package racingcar

import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carsSize = InputView.receiveCarsSize()
    val tryCount = InputView.receiveTryCount()
    val cars = Cars.from(carsSize)

    val result = RacingGame(cars, tryCount).run()

    ResultView.init()
    ResultView.printResult(result)
}
