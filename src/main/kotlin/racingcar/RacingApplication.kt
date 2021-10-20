package racingcar

import racingcar.manager.RacingManager
import racingcar.view.InputView
import racingcar.view.ResultView

object RacingApplication {

    private const val RACING_RESULT = "실행 결과"

    fun start() {
        val carNum = InputView.getNumberOfCars()
        val attempts = InputView.getNumberOfAttempts()
        println()
        println(RACING_RESULT)
        RacingManager(carNum, attempts).run {
            race(ResultView::printCarPositions)
        }
    }
}
