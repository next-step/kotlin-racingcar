package racingcar

import racingcar.controller.CarRacingController
import racingcar.view.CarRacingInputView
import racingcar.view.CarRacingOutputView

fun main() {
    val request = CarRacingInputView.getRequest()
    val response = CarRacingController.run(request)
    CarRacingOutputView.draw(response)
}
