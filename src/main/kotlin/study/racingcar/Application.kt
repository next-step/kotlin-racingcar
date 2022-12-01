package study.racingcar

import study.racingcar.controller.RacingController
import study.racingcar.domain.generator.RandomNumberGenerator
import study.racingcar.view.InputView
import study.racingcar.view.OutputView

fun main() {
    val controller = RacingController(InputView(), OutputView(), RandomNumberGenerator())
    controller.racing()
}
