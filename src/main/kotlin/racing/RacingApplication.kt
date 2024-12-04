package racing

import racing.controller.RacingControllerFactory
import racing.view.input.ConsoleInputViewFactory
import racing.view.result.ConsoleResultViewFactory

fun main() {
    val inputView = ConsoleInputViewFactory.newInstance()
    val resultView = ConsoleResultViewFactory.newInstance()
    val racingController = RacingControllerFactory.newInstance(inputView, resultView)
    racingController.start()
}
