package racingcar.racing

import racingcar.constant.Constant
import racingcar.ui.ResultView
import racingcar.util.RacingUtil

class Racing(private val carCount: Int, private val attemptCount: Int) {
    fun start() {
        val tempCarList = RacingUtil.getCarList(carCount)
        for (i in Constant.START..attemptCount) {
            val resultCarList = RacingUtil.getResultCarList(tempCarList)
            ResultView.printRacingResult(resultCarList)
        }
    }
}
