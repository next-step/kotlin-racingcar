package racingcar.controller

import racingcar.model.Car
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val (carNames, tryCount) = InputView.getCarNamesAndTryCount()
    val racingCar = mutableListOf<Car>().apply {
        for (name in carNames) {
            add(Car(name))
        }
    }

    startRacing(racingCar, tryCount)
    showRacingStep(racingCar, tryCount)
}

private fun startRacing(racingCar: List<Car>, tryCount: Int) {
    repeat(tryCount) {
        racingCar.forEach { it.updateDistanceCount() }
    }
}

private fun showRacingStep(racingCar: List<Car>, tryCount: Int) {
    ResultView.printRacingStep(racingCar, tryCount)
}
