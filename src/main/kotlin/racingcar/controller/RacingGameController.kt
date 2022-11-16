package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView

object RacingGameController {

    fun run() {
        val register = InputView.register()
        ResultView.executionResult()
        val raceResult =
            RacingGame.race(register, register.times) { ResultView.presentSituation(it.name, it.currentPosition) }
        ResultView.presentWinner(raceResult.cars)
    }
}
