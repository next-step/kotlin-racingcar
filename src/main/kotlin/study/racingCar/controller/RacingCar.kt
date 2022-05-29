package study.racingCar.controller

import study.racingCar.domain.RacingCarLogic
import study.racingCar.domain.WinnersLogic
import study.racingCar.view.InputView
import study.racingCar.view.ResultView

class RacingCar {
    fun startGame() {
        val carNames = InputView.inputCarNames()
        val tryNum = InputView.inputMovingTryNum()
        val mileageRecords = RacingCarLogic().startRacing(carNames, tryNum)
        val winners = WinnersLogic().judgeWinners(mileageRecords)

        ResultView.printResult(mileageRecords)
        ResultView.printWinners(winners)
    }
}

fun main(){
    val racingCar = RacingCar()
    racingCar.startGame()
}