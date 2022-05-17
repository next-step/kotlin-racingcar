package racing

import racing.ui.InputView
import racing.ui.ResultView

fun main() {
    val carInput = InputView().getInput()
    val gameResult = CarRacingGame(carInput).start()
    ResultView(gameResult).printResult()
}
