package racingcar

import racingcar.view.InputView

fun main() {
    val carsSize = InputView.receiveCarsSize()
    val tryCount = InputView.receiveTryCount()
    val cars = Cars.from(carsSize)
    RacingGame(cars, tryCount).run()
}
