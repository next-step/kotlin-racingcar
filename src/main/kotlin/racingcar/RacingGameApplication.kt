package racingcar

import racingcar.controller.RacingGameController
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    RacingGameApplication().run()
}

class RacingGameApplication {
    fun run() {
        val racingGameController = RacingGameController(
            inputView = InputView(),
            outputView = OutputView()
        )
        racingGameController.start()
    }
}
