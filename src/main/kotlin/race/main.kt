package race

import race.ui.InputView
import race.ui.RacingController
import race.ui.ResultView

fun main() {
    val racingController = RacingController(ResultView())
    InputView(racingController).submitInput()
}
