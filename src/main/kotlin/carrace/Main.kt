package carrace

import carrace.view.InputViewImpl
import carrace.view.ResultViewImpl

fun main() {
    val controller = Controller(
        inputView = InputViewImpl,
        resultView = ResultViewImpl
    )
    controller.startGame()
}
