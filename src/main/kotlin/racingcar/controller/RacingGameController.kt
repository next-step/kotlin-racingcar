package racingcar.controller

import racingcar.view.InputView

fun main() {
    val (racingCarNames, tryCounts) = InputView.requestRacingCarNames() to InputView.requestTryCount()
}
