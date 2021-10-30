package racingcar

import racingcar.engine.RacingCarEngineImpl
import racingcar.manager.RacingManagerFactory
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingApplication(private val inputView: InputView = InputView()) {

    fun start() {
        val carNames = inputView.getCarNames()
        val attempts = inputView.getNumberOfAttempts()
        val racingCarEngine = RacingCarEngineImpl()
        val racingManager = RacingManagerFactory().createRacingManager(carNames, racingCarEngine)

        ResultView.printResult()

        racingManager.run {
            ResultView.printWinners(race(ResultView::printCarPositions, attempts))
        }
    }
}
