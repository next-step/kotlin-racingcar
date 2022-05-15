package study.racingcar

import study.racingcar.service.RacingService
import study.racingcar.view.RacingInputView

class RacingCar {

    fun start() {
        val racingInputView = RacingInputView()

        val racingService = RacingService(racingInputView.getNumberOfCar(), racingInputView.getNumberOfTry())

        racingService.start()
    }
}
