package racingcar

import racingcar.ui.InputView
import racingcar.ui.ResultView

class RacingCarRace {
    fun race() {
        val carVo = InputView().execute()

        for (i in 0 until carVo.tryCount) {
            RacingCarMove.move(carVo.resultMoveList)
            ResultView().printResult(carVo, i)
        }
    }
}
