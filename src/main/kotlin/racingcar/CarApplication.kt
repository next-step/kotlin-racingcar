package racingcar

import racingcar.io.InputView
import racingcar.io.ResultView

fun main() {
    val (carNames, numberOfTry) = InputView.read()
    val game = Game(carNames, numberOfTry)
    val gameResult = game.execute()
    ResultView.print(gameResult)
}
