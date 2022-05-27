package study.racingCar.controller

import study.racingCar.domain.RacingCarLogic
import study.racingCar.view.InputView
import study.racingCar.view.ResultView

class RacingCar {
    fun startGame() {
        val carNames = InputView.inputCarNames()
        val tryNum = InputView.inputMovingTryNum()

        val carRacing = RacingCarLogic()
        val movedStepsRecords = carRacing.startRacing(carNames, tryNum)

        ResultView.printResult(movedStepsRecords)
    }
}

fun main(){
    val racingCar = RacingCar()
    racingCar.startGame()
}