package step3

import step3.view.InputView
import step3.view.ResultView

fun main() {
    val carsNumber = InputView.getCarsNumber()
    val runsNumber = InputView.getRunsNumber()

    var cars = Race.initiate(carsNumber)

    for (i in 0 until runsNumber) {
        cars = Race.makeTurn(cars)
        ResultView.output(cars)
    }
}


