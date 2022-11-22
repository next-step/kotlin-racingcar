package racing

import racing.ui.InputView

fun main() {
    RacingApplication.run()
}

object RacingApplication {

    fun run() {
        val numberOfCars = InputView.inputNumberOfCars()
        val countOfTry = InputView.inputCountOfTry()
    }
}
