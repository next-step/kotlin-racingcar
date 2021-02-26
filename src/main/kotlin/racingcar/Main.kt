package racingcar

import racingcar.model.RacingCar
import racingcar.utils.InputUtils

fun main() {
    val inputView = InputUtils.askQuestions()

    val racingCar = RacingCar.ready(inputView)

    for (i in 1..inputView.gameCount) {
        val resultViews = racingCar.runOnce()
        resultViews.printResultS()
    }
}
