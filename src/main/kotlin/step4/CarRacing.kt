package step4

import step4.view.InputView

fun main() {
    val nameListOfCars = InputView.getNameListOfCars()
    val numberOfTrials = InputView.getNumberOfTrials()

    var cars = Race.initiate(nameListOfCars)

    repeat(numberOfTrials) {
        cars = Race.makeTurn(cars)
    }
}
