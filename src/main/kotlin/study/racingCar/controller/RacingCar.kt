package study.racingCar.controller

import study.racingCar.domain.RacingCarLogic
import study.racingCar.view.InputView
import study.racingCar.view.ResultView

class RacingCar {
    fun startGame() {
        val carNum = InputView.inputCarNum()
        val tryNum = InputView.inputMovingTryNum()

        val carRacing = RacingCarLogic()
        val movedStepsRecords = carRacing.startRacing(carNum, tryNum)

        ResultView.printResult(movedStepsRecords)
    }
}