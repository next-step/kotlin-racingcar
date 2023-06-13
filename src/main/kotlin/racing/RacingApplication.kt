package racing

import racing.controller.RacingController
import racing.view.InputView
import racing.view.ResultView

class RacingApplication

fun main() {
    RacingController(InputView, ResultView).racingGame()
}
