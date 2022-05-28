package study.racingCar.controller

import study.racingCar.domain.RacingCarLogic
import study.racingCar.view.InputView
import study.racingCar.view.ResultView

class RacingCar {
    fun startGame() {
        val carNames = InputView.inputCarNames()
        val tryNum = InputView.inputMovingTryNum()
        val movedStepsRecords = RacingCarLogic().startRacing(carNames, tryNum)

        ResultView.printResult(movedStepsRecords)
        ResultView.printWinners(movedStepsRecords)
    }
}

fun main(){
    val racingCar = RacingCar()
    racingCar.startGame()
}