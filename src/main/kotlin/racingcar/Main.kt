package racingcar

import racingcar.domain.Cars
import racingcar.domain.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carNames = InputView.receiveCarNames()
    val tryCount = InputView.receiveTryCount()

    val cars = Cars.from(carNames)
    val result = RacingGame.run(cars, tryCount)

    ResultView.init()
    ResultView.printResult(result)
}
