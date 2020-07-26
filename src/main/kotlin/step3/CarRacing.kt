package step3

import step3.view.InputView
import step3.view.ResultView

fun main() {
    val carsNumber = InputView.getCarsNumber()
    val runsNumber = InputView.getRunsNumber()

    var cars = Race.initiate(carsNumber)

    repeat(numberOfRuns) {
        cars = Race.makeTurn(cars)
        ResultView.output(cars)
    }
}


