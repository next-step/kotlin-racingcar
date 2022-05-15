package step3

import step3.racingcar.CarRacing
import step3.racingcar.InputView
import step3.racingcar.ResultView

fun main() {
    val carCount = InputView.carCount()
    val movementCount = InputView.movementCount()

    CarRacing.execute(carCount, movementCount).also {
        ResultView.view(it, movementCount)
    }
}
