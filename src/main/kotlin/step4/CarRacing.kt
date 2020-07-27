package step4

import step4.view.InputView
import step4.view.ResultView

fun main() {
    val nameListOfCars = InputView.getNameListOfCars()
    val numberOfTrials = InputView.getNumberOfTrials()

    var cars = Race.initiate(nameListOfCars)

    repeat(numberOfTrials) {
        cars = Race.makeTurn(cars)
    }

    for (i in 0 until numberOfTrials) {
        val actualTrial = i + 1

        ResultView.output(actualTrial, cars)
    }
}
