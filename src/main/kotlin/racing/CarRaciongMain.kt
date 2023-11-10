package racing

import racing.ui.InputView

fun main() {
    val carNames = InputView.inputCarNames()
    val tryCount = InputView.inputTryCount()

    val cars = Racing.prepareRacing(carNames)
    for (i in 0 until tryCount) {
        Racing.startRacing(cars) { movable() }
    }
}

private fun movable(): Boolean {
    return (0..9).random() >= 4
}
