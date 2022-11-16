package racingcar

import racingcar.data.RacingCarInfo
import racingcar.ui.InputView
import racingcar.ui.ResultView

class RacingCarRace {
    fun race() {
        val inputView = InputView()
        val carCount = inputView.inputCarCount()
        val tryCount = inputView.inputTryCount()
        val carVo = RacingCarInfo(carCount, tryCount, ArrayList(Array(carCount) { 0 }.toList()))

        for (i in 0 until carVo.tryCount) {
            RacingCarMove.move(carVo.resultMoveList)
            ResultView().printResult(carVo, i)
        }
    }
}
