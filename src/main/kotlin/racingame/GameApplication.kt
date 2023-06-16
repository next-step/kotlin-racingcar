package racingame

import racingame.controller.GameController
import racingame.view.InputView
import racingame.view.OutputView

fun main() {
    val gameController = GameController(InputView(), OutputView())
    gameController.start()
}
