package step3

import step3.view.ConsoleInputView
import step3.view.ConsoleOutputView

fun main() {
    RacingGame(
        inputView = ConsoleInputView(),
        outputView = ConsoleOutputView()
    ).run()
}
