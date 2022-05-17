package racing

import racing.application.CarRacing
import racing.ui.RacingInputView
import racing.ui.RacingResultView

object RacingApp {
    fun launch() {
        val carNames = RacingInputView.getCarNames()
        val tries = RacingInputView.getTries()
        val racingResult = CarRacing(carNames, tries).start()

        val resultView = RacingResultView(tries, racingResult)

        resultView.display()
    }
}

fun main() {
    RacingApp.launch()
}
