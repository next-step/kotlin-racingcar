package racingcar

import racingcar.manager.RacingManager
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingApplication(private val inputView: InputView = InputView()) {

    fun start() {
        val carNum = inputView.getNumberOfCars()
        val attempts = inputView.getNumberOfAttempts()
        println()
        println(RACING_RESULT)
        RacingManager(carNum, attempts).run {
            race(ResultView::printCarPositions)
        }
    }

    companion object {
        private const val RACING_RESULT = "실행 결과"
    }
}
