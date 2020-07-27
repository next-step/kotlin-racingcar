package step3

import step3.view.InputView
import step3.view.ResultView

fun main() {
    val numberOfCars = InputView.getNumberOfCars()
    val numberOfTrials = InputView.getNumberOfTrials()

    var cars = Race.initiate(numberOfCars)

    repeat(numberOfTrials) {
        cars = Race.makeTurn(cars)
        ResultView.output(cars)
    }
}
