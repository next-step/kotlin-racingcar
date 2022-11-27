package racingcar

import racingcar.model.CarRacer

fun main() {
    val inputView = InputView()
    inputView.show()

    val f1 = FormularOne()
    val result: List<List<CarRacer>> =
        f1.start(numberOfCar = inputView.numberOfCar, numberOfGame = inputView.numberOfGame)

    ResultView().show(result = result)
}
