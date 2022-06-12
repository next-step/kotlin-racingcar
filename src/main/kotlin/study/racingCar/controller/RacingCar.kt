package study.racingCar.controller

import study.racingCar.domain.Game
import study.racingCar.domain.Winners
import study.racingCar.view.InputView
import study.racingCar.view.ResultView

class RacingCar {
    fun start() {
        val carNames = InputView.inputCarNames()
        val tryNum = InputView.inputMovingTryNum()
        val gameResult = Game().startGame(carNames, tryNum)
        val winners = Winners().judgeWinners(gameResult)

        ResultView.printResult(gameResult)
        ResultView.printWinners(winners)
    }
}

fun main() {
    val racingCar = RacingCar()
    racingCar.start()
}
