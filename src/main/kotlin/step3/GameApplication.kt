package step3

import step3.controller.GameController
import step3.view.InputView
import step3.view.OutputView

fun main() {
    val gameController = GameController(InputView(), OutputView())
    gameController.start()
}
