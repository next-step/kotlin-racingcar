package racingWinner

import racingWinner.race.Racing
import racingWinner.ui.InputView
import racingWinner.ui.ResultView

class CarRacingWinnerMain {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            startCarRacingWinner()
        }
    }
}

fun startCarRacingWinner() {
    val carNames = InputView.inputCarNames()
    val tryCount = InputView.inputTryCount()

    val cars = Racing.prepareRacing(carNames)
    for (i in 0 until tryCount) {
        Racing.startRacing(cars) { movable() }
    }
    ResultView.printResult(cars)
}

private fun movable(): Boolean {
    return (0..9).random() >= 4
}
