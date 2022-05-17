package racing

import racing.model.Cars
import racing.model.RacingGame
import racing.view.InputView
import racing.view.ResultView

fun main() {
    InputView.printCarNamesInputMessage()
    val carNames = InputView.inputCarNames()

    InputView.printTryCountInputMessage()
    val tryCount = InputView.inputTryCount()

    val cars = Cars.from(carNames)
    val racingGameResult = RacingGame.play(cars, tryCount)

    ResultView.printGameResult(racingGameResult)
}
