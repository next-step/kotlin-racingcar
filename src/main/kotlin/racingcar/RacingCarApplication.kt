package racingcar

import racingcar.controller.RacingController
import racingcar.domain.Record
import racingcar.view.InputView

class RacingCarApplication {

    fun main() {
        val racingController = RacingController(InputView(), Record())
        racingController.startGame()
    }
}
