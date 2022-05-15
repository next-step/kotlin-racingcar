package study.step3

import study.step3.service.RacingService
import study.step3.view.RacingInputView

class RacingCar {

    fun start() {
        val racingInputView = RacingInputView()

        val racingService = RacingService(racingInputView.getNumberOfCar(), racingInputView.getNumberOfTry())

        racingService.start()
    }
}
