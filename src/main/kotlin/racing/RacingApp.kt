package racing

import racing.application.CarRacing
import racing.ui.RacingInputView
import racing.ui.RacingResultView

object RacingApp {
    fun launch() {
        val carNames = RacingInputView.getCarNames()
        val tries = RacingInputView.getTries()
        val racing = CarRacing(carNames, tries)

        val raceResult = racing.start()
        RacingResultView.display(tries, raceResult)
    }
}

fun main() {
    RacingApp.launch()
}
