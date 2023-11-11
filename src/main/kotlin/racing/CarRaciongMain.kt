package racing

import racing.ui.InputView

fun main() {
    val carNames = InputView.inputCarNames()
    val tryCount = InputView.inputTryCount()

    val cars = CarNameMapper.map(carNames)
    val racing = Racing(cars, tryCount)
    racing.startRacing { movable() }
}

private fun movable(): Boolean {
    return (0..9).random() >= 4
}
