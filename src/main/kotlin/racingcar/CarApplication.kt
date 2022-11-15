package racingcar

import racingcar.domain.Game
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val (carNames, numberOfTry) = InputView.read()
    val game = Game(carNames, numberOfTry)
    val gameResult = game.execute()
    ResultView.print(gameResult)
}
