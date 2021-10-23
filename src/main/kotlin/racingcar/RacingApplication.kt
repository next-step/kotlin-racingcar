package racingcar

import racingcar.engine.RacingCarEngineImpl
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingApplication(private val inputView: InputView = InputView()) {

    fun start() {
        val carNum = inputView.getNumberOfCars()
        val attempts = inputView.getNumberOfAttempts()
        val racingCarEngine = RacingCarEngineImpl()
        val racingManager = RacingManagerFactory().createRacingManager(carNum, racingCarEngine)

        ResultView.printResult()

        racingManager.run {
            repeat(attempts) {
                race(ResultView::printCarPositions)
            }
        }
    }
}
