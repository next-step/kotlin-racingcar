package racingCar

import racingCar.controller.RacingController
import racingCar.view.InputView
import racingCar.view.ResultView

fun main() {
    RacingController(InputView(), ResultView()).start()
}
