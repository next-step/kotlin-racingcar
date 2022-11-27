package racingcar

import racingcar.domain.FormularOne
import racingcar.domain.model.CarRacer
import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {
    val inputView = InputView()
    inputView.show()

    val f1 = FormularOne()
    val result: List<List<CarRacer>> =
        f1.start(numberOfCar = inputView.numberOfCar, numberOfGame = inputView.numberOfGame)

    ResultView().show(result = result)
}
