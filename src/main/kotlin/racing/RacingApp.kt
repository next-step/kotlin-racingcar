package racing

import racing.application.CarRacing
import racing.ui.RacingInputView
import racing.ui.RacingResultView

object RacingApp {
    fun launch() {
        val carNames = RacingInputView.getCarNames()
        val tries = RacingInputView.getTries()
        val racingResult = CarRacing(carNames, tries).start()

        RacingResultView.display(tries, racingResult)
    }
}

fun main() {
    RacingApp.launch()
}
