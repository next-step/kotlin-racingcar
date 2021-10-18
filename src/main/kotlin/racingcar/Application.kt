package racingcar

import racingcar.domain.Record
import racingcar.ui.RacingController
import racingcar.view.InputView

fun main() {
    val racingController = RacingController(InputView(), Record.EMPTY)
    racingController.start()
}
