package racing

import racing.ui.InputView

fun main() {
    val carNames = InputView.inputCarNames()
    val tryCount = InputView.inputTryCount()

    val cars = CarNameMapper.map(carNames)
    val racing = Racing(cars, tryCount)
    racing.startRacing { MoveCondition.movable() }
}

