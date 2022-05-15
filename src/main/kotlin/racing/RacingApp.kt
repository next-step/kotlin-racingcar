package racing

import racing.application.CarRacing
import racing.ui.RacingInputView
import racing.ui.RacingResultView

object RacingApp {
    fun launch() {
        val numberOfCars = RacingInputView.getNumberOfCars()
        val tries = RacingInputView.getTries()
        val racingResult = CarRacing(numberOfCars, tries).start()

        val resultView = RacingResultView(tries, racingResult)

        resultView.display()
    }
}

fun main() {
    RacingApp.launch()
}
